package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.R;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes.dex */
public class d extends i {
    private static SimpleDateFormat uu = new SimpleDateFormat("HH:mm");
    private View ui;
    protected LinearLayout uj;
    protected ImageView uk;
    protected TextView ul;
    protected TextView um;
    private f uo;
    private g up;
    private String uq;
    private String ur;
    private String us;
    protected AnimationDrawable ut;

    public d(Context context) {
        super(context);
        this.ui = null;
        this.uj = null;
        this.uk = null;
        this.ul = null;
        this.um = null;
        this.uo = null;
        this.up = null;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public View hA() {
        Context context = getContext();
        return c(context.getString(R.string.adp_pull_to_refresh), context.getString(R.string.adp_release_to_refresh), context.getString(R.string.adp_loading));
    }

    public View c(String str, String str2, String str3) {
        Context context = getContext();
        if (str == null) {
            str = context.getString(R.string.adp_pull_to_refresh);
        }
        this.uq = str;
        if (str2 == null) {
            str2 = context.getString(R.string.adp_release_to_refresh);
        }
        this.ur = str2;
        if (str3 == null) {
            str3 = context.getString(R.string.adp_loading);
        }
        this.us = str3;
        this.ui = com.baidu.adp.lib.g.b.ek().inflate(getContext(), R.layout.pull_view, null);
        this.uj = (LinearLayout) this.ui.findViewById(R.id.pull_root);
        this.uk = (ImageView) this.ui.findViewById(R.id.pull_image);
        this.ut = new AnimationDrawable();
        Drawable drawable = context.getResources().getDrawable(R.drawable.listview_pull_refresh02);
        if (drawable != null) {
            this.ut.addFrame(drawable, 100);
        }
        Drawable drawable2 = context.getResources().getDrawable(R.drawable.listview_pull_refresh01);
        if (drawable2 != null) {
            this.ut.addFrame(drawable2, 100);
        }
        this.ut.setOneShot(false);
        this.uk.setBackgroundDrawable(this.ut);
        this.ul = (TextView) this.ui.findViewById(R.id.pull_text);
        this.um = (TextView) this.ui.findViewById(R.id.pull_time);
        aM(hG());
        return this.ui;
    }

    public View hB() {
        if (this.ui == null) {
            this.ui = hA();
        }
        return this.ui;
    }

    public TextView hC() {
        return this.um;
    }

    public TextView hD() {
        return this.ul;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public void hE() {
        this.ul.setVisibility(0);
        this.um.setVisibility(0);
        this.ut.stop();
        this.uk.setBackgroundDrawable(this.ut.getFrame(1));
        this.ul.setText(this.ur);
    }

    @Override // com.baidu.adp.widget.ListView.i
    public void E(boolean z) {
        this.ut.stop();
        this.uk.setBackgroundDrawable(this.ut.getFrame(0));
        this.ul.setVisibility(0);
        this.um.setVisibility(0);
        this.ul.setText(this.uq);
    }

    @Override // com.baidu.adp.widget.ListView.i
    public void hF() {
        this.ut.stop();
        this.uk.setBackgroundDrawable(this.ut);
        this.uk.post(new e(this));
        this.ul.setText(this.us);
        this.um.setVisibility(0);
    }

    @Override // com.baidu.adp.widget.ListView.i
    public void F(boolean z) {
        this.ut.stop();
        this.ul.setText(this.uq);
        this.um.setVisibility(0);
        if (z) {
            aM(hG());
        }
    }

    public static String hG() {
        String format;
        synchronized (uu) {
            format = uu.format(new Date());
        }
        return format;
    }

    public void aM(String str) {
        this.um.setText(String.valueOf(getContext().getString(R.string.adp_pull_view_date_tip)) + str);
    }

    @Override // com.baidu.adp.widget.ListView.i
    public void G(boolean z) {
        if (this.uo != null) {
            this.uo.H(z);
        }
        if (this.up != null) {
            this.up.a(this.ui, z);
        }
    }

    public void a(f fVar) {
        this.uo = fVar;
    }

    public void a(g gVar) {
        this.up = gVar;
    }
}
