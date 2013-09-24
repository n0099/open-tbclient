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

    /* renamed from: a  reason: collision with root package name */
    ListAdapter f272a;
    ListView b;
    View c;
    TextView d;
    View e;
    View f;
    CharSequence g;
    boolean h;
    private final Handler i = new Handler();
    private final Runnable Y = new af(this);
    private final AdapterView.OnItemClickListener Z = new ag(this);

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        n h = h();
        FrameLayout frameLayout = new FrameLayout(h);
        LinearLayout linearLayout = new LinearLayout(h);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(h, null, 16842874), new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(h);
        frameLayout2.setId(16711683);
        TextView textView = new TextView(h());
        textView.setId(16711681);
        textView.setGravity(17);
        frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ListView listView = new ListView(h());
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
    public void e() {
        this.i.removeCallbacks(this.Y);
        this.b = null;
        this.h = false;
        this.f = null;
        this.e = null;
        this.c = null;
        this.d = null;
        super.e();
    }

    public void a(ListView listView, View view, int i, long j) {
    }

    public void a(ListAdapter listAdapter) {
        boolean z = this.f272a != null;
        this.f272a = listAdapter;
        if (this.b != null) {
            this.b.setAdapter(listAdapter);
            if (!this.h && !z) {
                a(true, n().getWindowToken() != null);
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
                    this.e.startAnimation(AnimationUtils.loadAnimation(h(), 17432577));
                    this.f.startAnimation(AnimationUtils.loadAnimation(h(), 17432576));
                } else {
                    this.e.clearAnimation();
                    this.f.clearAnimation();
                }
                this.e.setVisibility(8);
                this.f.setVisibility(0);
                return;
            }
            if (z2) {
                this.e.startAnimation(AnimationUtils.loadAnimation(h(), 17432576));
                this.f.startAnimation(AnimationUtils.loadAnimation(h(), 17432577));
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
            View n = n();
            if (n == null) {
                throw new IllegalStateException("Content view not yet created");
            }
            if (n instanceof ListView) {
                this.b = (ListView) n;
            } else {
                this.d = (TextView) n.findViewById(16711681);
                if (this.d == null) {
                    this.c = n.findViewById(16908292);
                } else {
                    this.d.setVisibility(8);
                }
                this.e = n.findViewById(16711682);
                this.f = n.findViewById(16711683);
                View findViewById = n.findViewById(16908298);
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
            this.b.setOnItemClickListener(this.Z);
            if (this.f272a != null) {
                ListAdapter listAdapter = this.f272a;
                this.f272a = null;
                a(listAdapter);
            } else if (this.e != null) {
                a(false, false);
            }
            this.i.post(this.Y);
        }
    }
}
