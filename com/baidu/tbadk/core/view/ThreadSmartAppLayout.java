package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import d.b.b.e.p.k;
import d.b.h0.r.q.a;
import d.b.i.p;
import tbclient.SmartApp;
/* loaded from: classes3.dex */
public class ThreadSmartAppLayout extends RelativeLayout implements View.OnClickListener, p<a> {

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f13531e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f13532f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13533g;

    /* renamed from: h  reason: collision with root package name */
    public SmartApp f13534h;
    public View.OnClickListener i;

    public ThreadSmartAppLayout(Context context) {
        this(context, null);
    }

    public final TbPageContext b(Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getPageContext();
        }
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext();
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: c */
    public void a(a aVar) {
        if (aVar != null && aVar.n() != null && aVar.n().j1() != null) {
            SmartApp j1 = aVar.n().j1();
            this.f13534h = j1;
            if (!k.isEmpty(j1.avatar)) {
                this.f13531e.X(this.f13534h.avatar, 10, false, false);
            }
            if (!k.isEmpty(this.f13534h.name)) {
                this.f13532f.setText(this.f13534h.name + " " + getContext().getResources().getString(R.string.smart_app_suffix));
            } else {
                this.f13532f.setText(getContext().getResources().getString(R.string.intelligent_smart_app));
            }
            if (!k.isEmpty(this.f13534h._abstract)) {
                this.f13533g.setText(this.f13534h._abstract);
            } else {
                this.f13533g.setText(getContext().getResources().getString(R.string.smart_app_default_abstract));
            }
            setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    public void d() {
        SkinManager.setBackgroundResource(this, R.drawable.applets_cell_bg);
        SkinManager.setViewTextColor(this.f13532f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f13533g, R.color.CAM_X0107);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SmartApp smartApp = this.f13534h;
        if (smartApp == null) {
            return;
        }
        if (!d.b.i0.s.a.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
            if (k.isEmpty(this.f13534h.h5_url)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(b(getContext()), new String[]{this.f13534h.h5_url});
        }
        View.OnClickListener onClickListener = this.i;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.i = onClickListener;
    }

    public ThreadSmartAppLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadSmartAppLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.thread_smart_app_layout, (ViewGroup) this, true);
        HeadImageView headImageView = (HeadImageView) findViewById(R.id.iv_thread_smart_app_head);
        this.f13531e = headImageView;
        headImageView.setIsRound(true);
        this.f13531e.setPlaceHolder(1);
        this.f13532f = (TextView) findViewById(R.id.tv_thread_smart_app_title);
        this.f13533g = (TextView) findViewById(R.id.tv_thread_smart_app_abstract);
        setOnClickListener(this);
        d();
    }
}
