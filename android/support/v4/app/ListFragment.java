package android.support.v4.app;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
/* loaded from: classes.dex */
public class ListFragment extends Fragment {
    private final Handler V = new Handler();
    private final Runnable W = new u(this);
    private final AdapterView.OnItemClickListener X = new v(this);
    ListAdapter a;
    ListView b;
    View c;
    TextView d;
    View e;
    View f;
    CharSequence g;
    boolean h;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        g g = g();
        FrameLayout frameLayout = new FrameLayout(g);
        LinearLayout linearLayout = new LinearLayout(g);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(g, null, 16842874), new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(g);
        frameLayout2.setId(16711683);
        TextView textView = new TextView(g());
        textView.setId(16711681);
        textView.setGravity(17);
        frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ListView listView = new ListView(g());
        listView.setId(16908298);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // android.support.v4.app.Fragment
    public void a(View view, Bundle bundle) {
        super.a(view, bundle);
        a();
    }

    @Override // android.support.v4.app.Fragment
    public void d() {
        this.V.removeCallbacks(this.W);
        this.b = null;
        this.h = false;
        this.f = null;
        this.e = null;
        this.c = null;
        this.d = null;
        super.d();
    }

    public void a(ListView listView, View view, int i, long j) {
    }

    public void a(ListAdapter listAdapter) {
        boolean z = this.a != null;
        this.a = listAdapter;
        if (this.b != null) {
            this.b.setAdapter(listAdapter);
            if (!this.h && !z) {
                a(true, i().getWindowToken() != null);
            }
        }
    }

    private void a(boolean z, boolean z2) {
        a();
        if (this.e == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        if (this.h != z) {
            this.h = z;
            if (z) {
                if (z2) {
                    this.e.startAnimation(AnimationUtils.loadAnimation(g(), 17432577));
                    this.f.startAnimation(AnimationUtils.loadAnimation(g(), 17432576));
                } else {
                    this.e.clearAnimation();
                    this.f.clearAnimation();
                }
                this.e.setVisibility(8);
                this.f.setVisibility(0);
                return;
            }
            if (z2) {
                this.e.startAnimation(AnimationUtils.loadAnimation(g(), 17432576));
                this.f.startAnimation(AnimationUtils.loadAnimation(g(), 17432577));
            } else {
                this.e.clearAnimation();
                this.f.clearAnimation();
            }
            this.e.setVisibility(0);
            this.f.setVisibility(8);
        }
    }

    private void a() {
        if (this.b == null) {
            View i = i();
            if (i == null) {
                throw new IllegalStateException("Content view not yet created");
            }
            if (i instanceof ListView) {
                this.b = (ListView) i;
            } else {
                this.d = (TextView) i.findViewById(16711681);
                if (this.d == null) {
                    this.c = i.findViewById(16908292);
                } else {
                    this.d.setVisibility(8);
                }
                this.e = i.findViewById(16711682);
                this.f = i.findViewById(16711683);
                View findViewById = i.findViewById(16908298);
                if (!(findViewById instanceof ListView)) {
                    if (findViewById == null) {
                        throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                    }
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
                this.b = (ListView) findViewById;
                if (this.c != null) {
                    this.b.setEmptyView(this.c);
                } else if (this.g != null) {
                    this.d.setText(this.g);
                    this.b.setEmptyView(this.d);
                }
            }
            this.h = true;
            this.b.setOnItemClickListener(this.X);
            if (this.a != null) {
                ListAdapter listAdapter = this.a;
                this.a = null;
                a(listAdapter);
            } else if (this.e != null) {
                a(false, false);
            }
            this.V.post(this.W);
        }
    }
}
