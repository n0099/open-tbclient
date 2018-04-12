package com.baidu.android.pushservice.richmedia;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.android.pushservice.d.a;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.richmedia.c;
import com.baidu.ar.util.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class MediaListActivity extends Activity {
    private static String r = "downloadUrl";
    ArrayList<HashMap<String, Object>> a;
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
    private final AdapterView.OnItemClickListener s = new AdapterView.OnItemClickListener() { // from class: com.baidu.android.pushservice.richmedia.MediaListActivity.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            String str;
            Uri fromFile;
            a.g a2 = com.baidu.android.pushservice.d.a.a(MediaListActivity.this, (String) ((HashMap) adapterView.getItemAtPosition(i)).get(MediaListActivity.r));
            if (a2 != null) {
                if (a2.i != com.baidu.android.pushservice.richmedia.a.f) {
                    MediaListActivity.this.a(a2.b, a2.c, a2.d);
                    return;
                }
                String str2 = a2.e;
                if (a2.f.length() > 0) {
                    String str3 = str2 + "/" + str.substring(0, str.lastIndexOf(Constants.DOT)) + "/index.html";
                    Intent intent = new Intent();
                    intent.setClass(MediaListActivity.this, MediaViewActivity.class);
                    int A = m.A(MediaListActivity.this, MediaListActivity.this.getPackageName());
                    File file = new File(str3);
                    if (A >= 24) {
                        ContentValues contentValues = new ContentValues(1);
                        contentValues.put("_data", file.getAbsolutePath());
                        fromFile = MediaListActivity.this.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                    } else {
                        fromFile = Uri.fromFile(file);
                    }
                    intent.setData(fromFile);
                    intent.addFlags(268435456);
                    MediaListActivity.this.startActivity(intent);
                }
            }
        }
    };
    private final AdapterView.OnItemLongClickListener t = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.android.pushservice.richmedia.MediaListActivity.3
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, final long j) {
            new AlertDialog.Builder(MediaListActivity.this).setTitle("提示").setMessage("确定要删除该记录？").setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.baidu.android.pushservice.richmedia.MediaListActivity.3.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    String str = (String) MediaListActivity.this.a.get((int) j).get(MediaListActivity.r);
                    a.g a2 = com.baidu.android.pushservice.d.a.a(MediaListActivity.this, str);
                    if (a2 != null) {
                        new File(a2.e).delete();
                    }
                    com.baidu.android.pushservice.d.a.b(MediaListActivity.this, str);
                    Intent intent = new Intent();
                    intent.setClass(MediaListActivity.this, MediaListActivity.class);
                    MediaListActivity.this.startActivity(intent);
                }
            }).setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.baidu.android.pushservice.richmedia.MediaListActivity.3.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                }
            }).show();
            return true;
        }
    };

    /* loaded from: classes3.dex */
    public class a extends BaseAdapter {
        private final Context b;
        private final ArrayList<HashMap<String, Object>> c;

        public a(Context context, ArrayList<HashMap<String, Object>> arrayList) {
            this.b = context;
            this.c = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.c.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.c == null || i >= this.c.size()) {
                return null;
            }
            return this.c.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            HashMap<String, Object> hashMap;
            View inflate = LayoutInflater.from(this.b.getApplicationContext()).inflate(MediaListActivity.this.e, (ViewGroup) null);
            inflate.setBackgroundColor(-7829368);
            ImageView imageView = (ImageView) inflate.findViewById(MediaListActivity.this.g);
            TextView textView = (TextView) inflate.findViewById(MediaListActivity.this.h);
            TextView textView2 = (TextView) inflate.findViewById(MediaListActivity.this.i);
            TextView textView3 = (TextView) inflate.findViewById(MediaListActivity.this.j);
            try {
                if (this.c != null && i < this.c.size() && (hashMap = this.c.get(i)) != null) {
                    if (textView != null && hashMap.get("title") != null) {
                        textView.setText(hashMap.get("title").toString());
                    }
                    if (textView2 != null && hashMap.get("fromtext") != null) {
                        textView2.setText(hashMap.get("fromtext").toString());
                    }
                    if (textView3 != null && hashMap.get("timetext") != null) {
                        textView3.setText(hashMap.get("timetext").toString());
                    }
                    if (imageView != null && hashMap.get("img") != null) {
                        imageView.setImageDrawable((Drawable) hashMap.get("img"));
                    }
                }
            } catch (Exception e) {
            }
            return inflate;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        Uri parse = Uri.parse(str);
        String path = parse.getPath();
        String str4 = new String();
        if (path.length() > 0) {
            str4 = path.substring(0, path.lastIndexOf(47));
        }
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/baidu/pushservice/files/" + parse.getAuthority() + "/" + str4);
        c a2 = d.a(c.a.REQ_TYPE_GET_ZIP, parse.toString());
        a2.b = file.getAbsolutePath();
        a2.c = str2;
        a2.d = str3;
        new com.baidu.android.pushservice.richmedia.a(this, new f() { // from class: com.baidu.android.pushservice.richmedia.MediaListActivity.4
            @Override // com.baidu.android.pushservice.richmedia.f
            public void a(com.baidu.android.pushservice.richmedia.a aVar) {
            }

            @Override // com.baidu.android.pushservice.richmedia.f
            public void a(com.baidu.android.pushservice.richmedia.a aVar, b bVar) {
                String c = aVar.d.c();
                if (bVar.a == bVar.b || MediaListActivity.this.m == null) {
                    return;
                }
                int i = (int) ((bVar.a * 100.0d) / bVar.b);
                MediaListActivity.this.m.setTextViewText(MediaListActivity.this.o, i + "%");
                MediaListActivity.this.m.setTextViewText(MediaListActivity.this.p, c);
                MediaListActivity.this.m.setProgressBar(MediaListActivity.this.n, 100, i, false);
                MediaListActivity.this.m.setImageViewResource(MediaListActivity.this.q, 17301633);
                Notification build = Build.VERSION.SDK_INT >= 16 ? new Notification.Builder(MediaListActivity.this).setSmallIcon(17301633).setWhen(System.currentTimeMillis()).build() : new Notification(17301633, null, System.currentTimeMillis());
                build.contentView = MediaListActivity.this.m;
                build.contentIntent = PendingIntent.getActivity(MediaListActivity.this, 0, new Intent(), 0);
                build.flags |= 32;
                build.flags |= 2;
                MediaListActivity.this.b.notify(c, 0, build);
            }

            @Override // com.baidu.android.pushservice.richmedia.f
            public void a(com.baidu.android.pushservice.richmedia.a aVar, e eVar) {
                String str5;
                Uri fromFile;
                String c = aVar.d.c();
                MediaListActivity.this.b.cancel(c, 0);
                a.g a3 = com.baidu.android.pushservice.d.a.a(MediaListActivity.this, c);
                if (a3 == null || a3.i != com.baidu.android.pushservice.richmedia.a.f) {
                    return;
                }
                String str6 = a3.e;
                if (a3.f.length() > 0) {
                    String str7 = str6 + "/" + str5.substring(0, str5.lastIndexOf(Constants.DOT)) + "/index.html";
                    Intent intent = new Intent();
                    intent.setClass(MediaListActivity.this, MediaViewActivity.class);
                    int A = m.A(MediaListActivity.this, MediaListActivity.this.getPackageName());
                    File file2 = new File(str7);
                    if (A >= 24) {
                        ContentValues contentValues = new ContentValues(1);
                        contentValues.put("_data", file2.getAbsolutePath());
                        fromFile = MediaListActivity.this.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                    } else {
                        fromFile = Uri.fromFile(file2);
                    }
                    intent.setData(fromFile);
                    intent.addFlags(268435456);
                    MediaListActivity.this.startActivity(intent);
                }
            }

            @Override // com.baidu.android.pushservice.richmedia.f
            public void a(com.baidu.android.pushservice.richmedia.a aVar, Throwable th) {
                MediaListActivity.this.b.cancel(aVar.d.c(), 0);
                MediaListActivity.this.runOnUiThread(new Runnable() { // from class: com.baidu.android.pushservice.richmedia.MediaListActivity.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast makeText = Toast.makeText(MediaListActivity.this, "下载富媒体失败", 1);
                        makeText.setGravity(17, 0, 0);
                        makeText.show();
                    }
                });
            }

            @Override // com.baidu.android.pushservice.richmedia.f
            public void b(com.baidu.android.pushservice.richmedia.a aVar) {
                MediaListActivity.this.b.cancel(aVar.d.c(), 0);
            }
        }, a2).start();
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
            this.f = resources.getIdentifier("bpush_type_listview", "id", packageName);
            this.g = resources.getIdentifier("bpush_media_list_img", "id", packageName);
            this.h = resources.getIdentifier("bpush_media_list_title", "id", packageName);
            this.i = resources.getIdentifier("bpush_media_list_from_text", "id", packageName);
            this.j = resources.getIdentifier("bpush_media_list_time_text", "id", packageName);
            this.k = resources.getIdentifier("bpush_media_none_layout", "id", packageName);
            this.l = (LinearLayout) findViewById(this.k);
            this.c = (ListView) findViewById(this.f);
            Button button = (Button) findViewById(resources.getIdentifier("bpush_media_list_return_btn", "id", packageName));
            button.setClickable(true);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.android.pushservice.richmedia.MediaListActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    MediaListActivity.this.finish();
                }
            });
            int identifier = getResources().getIdentifier("bpush_download_progress", "layout", getPackageName());
            if (identifier != 0) {
                this.m = new RemoteViews(getPackageName(), identifier);
                this.n = getResources().getIdentifier("bpush_downLoad_progress", "id", getPackageName());
                this.o = getResources().getIdentifier("bpush_progress_percent", "id", getPackageName());
                this.p = getResources().getIdentifier("bpush_progress_text", "id", getPackageName());
                this.q = getResources().getIdentifier("bpush_downLoad_icon", "id", getPackageName());
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
        this.a = new ArrayList<>();
        List<a.g> b = com.baidu.android.pushservice.d.a.b(this);
        if (b == null || b.isEmpty()) {
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
                this.c.setAdapter((ListAdapter) new a(this, this.a));
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(b.get(i2).a, 0);
                hashMap.put(strArr[0], packageManager.getApplicationIcon(applicationInfo));
                hashMap.put(strArr[1], b.get(i2).c);
                hashMap.put(strArr[2], "来自：" + ((Object) packageManager.getApplicationLabel(applicationInfo)));
                hashMap.put(strArr[3], m.a(b.get(i2).j));
                hashMap.put(r, b.get(i2).b);
                this.a.add(hashMap);
            } catch (PackageManager.NameNotFoundException e) {
            }
            i = i2 + 1;
        }
    }
}
