package com.baidu.mapapi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.mapapi.d;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
/* loaded from: classes.dex */
public class PlaceCaterActivity extends Activity implements d.a {
    static ImageView c;
    static DisplayMetrics n;

    /* renamed from: a  reason: collision with root package name */
    TextView f533a;
    TextView b;
    LinearLayout d;
    TextView e;
    TextView f;
    TextView g;
    TextView h;
    TextView i;
    TextView j;
    TextView k;
    TextView l;
    LinearLayout m;
    private static int q = -2;
    private static int r = -1;
    private static int s = 10;
    private static int t = 5;
    private static int u = 1;
    private static int v = -7566196;
    private static int w = -12487463;
    private static int x = -1710619;
    static Hashtable o = new Hashtable();
    static Handler p = new q();

    private Bitmap a(String str) {
        try {
            return BitmapFactory.decodeStream(getAssets().open(str));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void a(LinearLayout linearLayout, List list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.m.removeAllViews();
        o.clear();
        int size = list.size();
        int i = (size / 2) + (size % 2);
        for (int i2 = 0; i2 < i; i2++) {
            LinearLayout linearLayout2 = new LinearLayout(this);
            linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(r, q));
            linearLayout.addView(linearLayout2);
            LinearLayout linearLayout3 = new LinearLayout(this);
            linearLayout3.setOrientation(0);
            linearLayout3.setLayoutParams(new ViewGroup.LayoutParams(r, q));
            linearLayout3.setPadding(20, 5, 5, 5);
            linearLayout2.addView(linearLayout3);
            ((LinearLayout.LayoutParams) linearLayout3.getLayoutParams()).weight = 1.0f;
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new ViewGroup.LayoutParams((int) (22.0f * n.density), (int) (22.0f * n.density)));
            imageView.setTag(Integer.valueOf(i2 * 2));
            d.a(linearLayout.hashCode(), (i2 * 2) + 1, h.f556a.replaceAll("#replace#", ((h) list.get(i2 * 2)).d), this);
            o.put(Integer.valueOf((i2 * 2) + 1), imageView);
            linearLayout3.addView(imageView);
            ((LinearLayout.LayoutParams) imageView.getLayoutParams()).gravity = 17;
            TextView textView = new TextView(this);
            textView.setTag(list.get(i2 * 2));
            textView.setPadding(s, s, s, s);
            textView.setLayoutParams(new ViewGroup.LayoutParams(q, q));
            textView.setClickable(true);
            textView.setText(((h) list.get(i2 * 2)).b);
            textView.setTextColor(w);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mapapi.PlaceCaterActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    h hVar = (h) view.getTag();
                    PlaceCaterActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(hVar.c)));
                    s.a().a("place_cater_moreinfo_click", "{\"cat\":\"" + hVar.b + "\"}");
                }
            });
            linearLayout3.addView(textView);
            ((LinearLayout.LayoutParams) textView.getLayoutParams()).gravity = 17;
            if ((i2 * 2) + 1 < size) {
                LinearLayout linearLayout4 = new LinearLayout(this);
                linearLayout4.setPadding(20, 5, 5, 5);
                linearLayout4.setLayoutParams(new ViewGroup.LayoutParams(r, q));
                linearLayout2.addView(linearLayout4);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout4.getLayoutParams();
                layoutParams.weight = 1.0f;
                layoutParams.gravity = 17;
                ImageView imageView2 = new ImageView(this);
                imageView2.setLayoutParams(new ViewGroup.LayoutParams((int) (22.0f * n.density), (int) (22.0f * n.density)));
                list.get((i2 * 2) + 1);
                d.a(linearLayout.hashCode(), (i2 * 2) + 1 + 1, h.f556a.replaceAll("#replace#", ((h) list.get((i2 * 2) + 1)).d), this);
                o.put(Integer.valueOf((i2 * 2) + 1 + 1), imageView2);
                linearLayout4.addView(imageView2);
                ((LinearLayout.LayoutParams) imageView2.getLayoutParams()).gravity = 16;
                TextView textView2 = new TextView(this);
                textView2.setTag(list.get((i2 * 2) + 1));
                textView2.setPadding(s, s, s, s);
                textView2.setClickable(true);
                textView2.setTextColor(w);
                textView2.setText(((h) list.get((i2 * 2) + 1)).b);
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mapapi.PlaceCaterActivity.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        h hVar = (h) view.getTag();
                        PlaceCaterActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(hVar.c)));
                        s.a().a("place_cater_moreinfo_click", "{\"cat\":\"" + hVar.b + "\"}");
                    }
                });
                linearLayout4.addView(textView2);
                ((LinearLayout.LayoutParams) textView2.getLayoutParams()).gravity = 17;
            }
        }
    }

    void a(float f) {
        if (this.d == null) {
            return;
        }
        this.d.removeAllViews();
        int i = (int) f;
        for (int i2 = 0; i2 < 5; i2++) {
            if (i2 < i) {
                ImageView imageView = new ImageView(this);
                imageView.setImageBitmap(a("star_light.png"));
                imageView.setLayoutParams(new ViewGroup.LayoutParams((int) (n.density * 20.0f), (int) (n.density * 20.0f)));
                imageView.setPadding(1, 1, 1, 1);
                this.d.addView(imageView);
            } else {
                ImageView imageView2 = new ImageView(this);
                imageView2.setImageBitmap(a("star_gray.png"));
                imageView2.setLayoutParams(new ViewGroup.LayoutParams((int) (n.density * 20.0f), (int) (n.density * 20.0f)));
                imageView2.setPadding(1, 1, 1, 1);
                this.d.addView(imageView2);
            }
        }
        TextView textView = new TextView(this);
        textView.setLayoutParams(new ViewGroup.LayoutParams(q, q));
        textView.setText(Float.toString(f));
        textView.setPadding(10, 0, 10, 0);
        textView.setTextColor(-16777216);
        this.d.addView(textView);
    }

    void a(DisplayMetrics displayMetrics) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-3355444);
        linearLayout.setPadding(1, 1, 1, 1);
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setPadding(1, 1, 1, 1);
        linearLayout2.setBackgroundColor(-1);
        linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(r, q));
        linearLayout2.setOrientation(1);
        linearLayout.addView(linearLayout2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout2.getLayoutParams();
        layoutParams.rightMargin = u;
        layoutParams.bottomMargin = u;
        layoutParams.topMargin = u;
        layoutParams.leftMargin = u;
        this.f533a = new TextView(this);
        this.f533a.setLayoutParams(new ViewGroup.LayoutParams(r, q));
        this.f533a.setTextSize(18.0f);
        this.f533a.setText("");
        this.f533a.setPadding(t, t, t, t);
        this.f533a.setTextColor(-16777216);
        this.f533a.setTypeface(Typeface.DEFAULT, 1);
        linearLayout2.addView(this.f533a);
        ((LinearLayout.LayoutParams) this.f533a.getLayoutParams()).leftMargin = 1;
        this.b = new TextView(this);
        this.b.setLayoutParams(new ViewGroup.LayoutParams(r, q));
        this.b.setTextSize(16.0f);
        this.b.setPadding(s, s, s, s);
        this.b.setTextColor(v);
        linearLayout2.addView(this.b);
        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setBackgroundColor(-1);
        linearLayout3.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout.addView(linearLayout3);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) linearLayout3.getLayoutParams();
        layoutParams2.topMargin = u;
        layoutParams2.rightMargin = u;
        layoutParams2.bottomMargin = u;
        layoutParams2.leftMargin = u;
        c = new ImageView(this);
        c.setPadding(5, 5, 5, 5);
        c.setLayoutParams(new ViewGroup.LayoutParams((int) (120.0f * displayMetrics.density), (int) (90.0f * displayMetrics.density)));
        linearLayout3.addView(c);
        LinearLayout linearLayout4 = new LinearLayout(this);
        linearLayout4.setOrientation(1);
        linearLayout4.setLayoutParams(new ViewGroup.LayoutParams(r, q));
        linearLayout4.setPadding(s, s, s, s);
        linearLayout3.addView(linearLayout4);
        ((LinearLayout.LayoutParams) linearLayout4.getLayoutParams()).gravity = 16;
        this.d = new LinearLayout(this);
        this.d.setPadding(2, 2, 2, 2);
        this.d.setOrientation(0);
        linearLayout4.addView(this.d);
        LinearLayout linearLayout5 = new LinearLayout(this);
        linearLayout5.setPadding(2, 2, 2, 2);
        linearLayout5.setLayoutParams(new ViewGroup.LayoutParams(q, q));
        linearLayout4.addView(linearLayout5);
        TextView textView = new TextView(this);
        textView.setTextColor(v);
        textView.setTextSize(16.0f);
        textView.setText("参考价：");
        linearLayout5.addView(textView);
        this.e = new TextView(this);
        this.e.setTextColor(-4712681);
        this.e.setTextSize(16.0f);
        linearLayout5.addView(this.e);
        LinearLayout linearLayout6 = new LinearLayout(this);
        linearLayout6.setPadding(2, 2, 2, 2);
        linearLayout4.addView(linearLayout6);
        this.f = new TextView(this);
        this.f.setPadding(0, 0, 5, 0);
        this.f.setText("口味:3.0");
        this.f.setTextColor(v);
        this.f.setTextSize(12.0f);
        linearLayout6.addView(this.f);
        this.g = new TextView(this);
        this.g.setPadding(0, 0, 5, 0);
        this.g.setText("服务:3.0");
        this.g.setTextColor(v);
        this.g.setTextSize(12.0f);
        linearLayout6.addView(this.g);
        this.h = new TextView(this);
        this.h.setPadding(0, 0, 5, 0);
        this.h.setText("环境:3.0");
        this.h.setTextColor(v);
        this.h.setTextSize(12.0f);
        linearLayout6.addView(this.h);
        LinearLayout linearLayout7 = new LinearLayout(this);
        linearLayout7.setBackgroundColor(-1);
        linearLayout7.setPadding(5, 5, 5, 5);
        linearLayout7.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout7.setOrientation(0);
        linearLayout.addView(linearLayout7);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) linearLayout7.getLayoutParams();
        layoutParams3.topMargin = u;
        layoutParams3.rightMargin = u;
        layoutParams3.bottomMargin = u;
        layoutParams3.leftMargin = u;
        linearLayout7.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mapapi.PlaceCaterActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    PlaceCaterActivity.this.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + PlaceCaterActivity.this.i.getText().toString().trim())));
                    s.a().a("place_telbutton_click", (String) null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ImageView imageView = new ImageView(this);
        imageView.setPadding(5, 5, 5, 5);
        imageView.setLayoutParams(new ViewGroup.LayoutParams((int) (35.0f * displayMetrics.density), (int) (35.0f * displayMetrics.density)));
        imageView.setImageBitmap(a("iconphone.png"));
        linearLayout7.addView(imageView);
        ((LinearLayout.LayoutParams) imageView.getLayoutParams()).gravity = 16;
        this.i = new TextView(this);
        this.i.setTextColor(-16777216);
        this.i.setText("(010)4343243");
        this.i.setPadding(5, 5, 5, 5);
        this.i.setTextSize(16.0f);
        this.i.setLayoutParams(new ViewGroup.LayoutParams(q, q));
        linearLayout7.addView(this.i);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams4.weight = 1.0f;
        layoutParams4.gravity = 16;
        ImageView imageView2 = new ImageView(this);
        imageView2.setLayoutParams(new ViewGroup.LayoutParams(q, q));
        imageView2.setImageBitmap(a("arrow.png"));
        imageView2.setPadding(5, 5, 5, 10);
        linearLayout7.addView(imageView2);
        ((LinearLayout.LayoutParams) imageView2.getLayoutParams()).gravity = 16;
        LinearLayout linearLayout8 = new LinearLayout(this);
        linearLayout8.setBackgroundColor(x);
        linearLayout8.setLayoutParams(new ViewGroup.LayoutParams(r, q));
        linearLayout8.setOrientation(1);
        linearLayout.addView(linearLayout8);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) linearLayout8.getLayoutParams();
        layoutParams5.topMargin = u;
        layoutParams5.rightMargin = u;
        layoutParams5.bottomMargin = u;
        layoutParams5.leftMargin = u;
        TextView textView2 = new TextView(this);
        textView2.setTextSize(18.0f);
        textView2.setText("商户简介");
        textView2.setPadding(t, t, t, t);
        textView2.setTextColor(-16777216);
        textView2.setLayoutParams(new ViewGroup.LayoutParams(q, q));
        linearLayout8.addView(textView2);
        this.j = new TextView(this);
        this.j.setBackgroundColor(-1);
        this.j.setTextColor(v);
        this.j.setPadding(s, s, s, s);
        this.j.setTextSize(16.0f);
        this.j.setLayoutParams(new ViewGroup.LayoutParams(r, q));
        linearLayout8.addView(this.j);
        this.k = new TextView(this);
        this.k.setBackgroundColor(-1);
        this.k.setTextColor(v);
        this.k.setPadding(s, s, s, s);
        this.k.setTextSize(16.0f);
        this.k.setLayoutParams(new ViewGroup.LayoutParams(r, q));
        linearLayout8.addView(this.k);
        LinearLayout linearLayout9 = new LinearLayout(this);
        linearLayout9.setBackgroundColor(x);
        linearLayout9.setOrientation(1);
        linearLayout9.setLayoutParams(new ViewGroup.LayoutParams(r, q));
        linearLayout.addView(linearLayout9);
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) linearLayout9.getLayoutParams();
        layoutParams6.topMargin = u;
        layoutParams6.rightMargin = u;
        layoutParams6.bottomMargin = u;
        layoutParams6.leftMargin = u;
        TextView textView3 = new TextView(this);
        textView3.setLayoutParams(new ViewGroup.LayoutParams(r, q));
        textView3.setText("评论信息");
        textView3.setPadding(t, t, t, t);
        textView3.setTextColor(-16777216);
        textView3.setTextSize(18.0f);
        linearLayout9.addView(textView3);
        this.l = new TextView(this);
        this.l.setPadding(s, s, s, s);
        this.l.setBackgroundColor(-1);
        this.l.setLayoutParams(new ViewGroup.LayoutParams(r, q));
        this.l.setTextSize(16.0f);
        this.l.setTextColor(v);
        linearLayout9.addView(this.l);
        LinearLayout linearLayout10 = new LinearLayout(this);
        linearLayout10.setBackgroundColor(x);
        linearLayout10.setOrientation(1);
        linearLayout10.setLayoutParams(new ViewGroup.LayoutParams(r, q));
        linearLayout.addView(linearLayout10);
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) linearLayout10.getLayoutParams();
        layoutParams7.topMargin = u;
        layoutParams7.rightMargin = u;
        layoutParams7.bottomMargin = u;
        layoutParams7.leftMargin = u;
        TextView textView4 = new TextView(this);
        textView4.setLayoutParams(new ViewGroup.LayoutParams(q, q));
        textView4.setTextSize(18.0f);
        textView4.setPadding(t, t, t, t);
        textView4.setTextColor(-16777216);
        textView4.setText("查看更多");
        linearLayout10.addView(textView4);
        this.m = new LinearLayout(this);
        this.m.setOrientation(1);
        this.m.setBackgroundColor(-1);
        this.m.setLayoutParams(new ViewGroup.LayoutParams(r, q));
        linearLayout10.addView(this.m);
        ScrollView scrollView = new ScrollView(this);
        scrollView.setPadding(5, 5, 0, 5);
        scrollView.setLayoutParams(new ViewGroup.LayoutParams(r, r));
        scrollView.setBackgroundColor(-526345);
        scrollView.addView(linearLayout);
        ((FrameLayout.LayoutParams) linearLayout.getLayoutParams()).rightMargin = 5;
        setContentView(scrollView);
    }

    void a(l lVar) {
        this.f533a.setText(lVar.f559a);
        this.b.setText("地址：" + lVar.b);
        this.e.setText("￥" + lVar.g);
        this.f.setText("口味:" + lVar.h);
        this.g.setText("服务:" + lVar.j);
        this.h.setText("环境:" + lVar.i);
        this.i.setText(lVar.c);
        if (lVar.l == null || "".equals(lVar.l)) {
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
            this.j.setText("推荐菜：" + lVar.l);
        }
        if (lVar.k == null || "".equals(lVar.k)) {
            this.k.setVisibility(8);
        } else {
            this.k.setVisibility(0);
            this.k.setText("商户描述：" + lVar.k);
        }
        if (lVar.m == null || "".equals(lVar.m)) {
            this.l.setVisibility(8);
        } else {
            this.l.setVisibility(0);
            this.l.setText(lVar.m);
        }
        if (lVar.e != null) {
            d.a(c.hashCode(), 0, lVar.e, this);
        }
        float f = 0.0f;
        try {
            f = Float.valueOf(lVar.f).floatValue();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        a(f);
        a(this.m, lVar.o);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        l lVar = new l();
        lVar.f559a = extras.getString("name");
        lVar.b = extras.getString("addr");
        lVar.c = extras.getString("tel");
        lVar.d = extras.getString("uid");
        lVar.e = extras.getString("image");
        lVar.f = extras.getString("overall_rating");
        lVar.g = extras.getString("price");
        lVar.h = extras.getString("taste_rating");
        lVar.i = extras.getString("enviroment_raing");
        lVar.j = extras.getString("service_rating");
        lVar.k = extras.getString("description");
        lVar.l = extras.getString("recommendation");
        lVar.m = extras.getString("review");
        lVar.n = extras.getString("user_logo");
        String[] stringArray = extras.getStringArray("aryMoreLinkName");
        String[] stringArray2 = extras.getStringArray("aryMoreLinkUrl");
        String[] stringArray3 = extras.getStringArray("aryMoreLinkCnName");
        if (stringArray != null && stringArray2 != null) {
            for (int i = 0; i < stringArray2.length; i++) {
                if (!"dianping".equals(stringArray[i])) {
                    h hVar = new h();
                    hVar.d = stringArray[i];
                    hVar.c = stringArray2[i];
                    hVar.b = stringArray3[i];
                    lVar.o.add(hVar);
                }
            }
        }
        if (lVar.c == null || "".equals(lVar.c)) {
            s.a().a("place_notel_show", (String) null);
        } else {
            s.a().a("place_tel_show", (String) null);
        }
        n = getResources().getDisplayMetrics();
        a(n);
        a(lVar);
    }

    @Override // com.baidu.mapapi.d.a
    public void onError(int i, int i2, String str, Object obj) {
        Log.d("kal", "onError  :  url=" + str);
    }

    @Override // com.baidu.mapapi.d.a
    public void onOk(int i, int i2, String str, Object obj) {
        if (i == c.hashCode()) {
            Message obtainMessage = p.obtainMessage(1);
            obtainMessage.obj = obj;
            obtainMessage.sendToTarget();
        } else if (i == this.m.hashCode()) {
            Message obtainMessage2 = p.obtainMessage(2);
            obtainMessage2.obj = obj;
            obtainMessage2.arg1 = i2;
            obtainMessage2.sendToTarget();
        }
    }
}
