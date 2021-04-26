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
import d.a.c.e.p.k;
import d.a.i.p;
import d.a.i0.r.q.a;
import tbclient.SmartApp;
/* loaded from: classes3.dex */
public class ThreadSmartAppLayout extends RelativeLayout implements View.OnClickListener, p<a> {

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f13151e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f13152f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13153g;

    /* renamed from: h  reason: collision with root package name */
    public SmartApp f13154h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f13155i;

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
    @Override // d.a.i.p
    /* renamed from: c */
    public void a(a aVar) {
        if (aVar != null && aVar.m() != null && aVar.m().j1() != null) {
            SmartApp j1 = aVar.m().j1();
            this.f13154h = j1;
            if (!k.isEmpty(j1.avatar)) {
                this.f13151e.W(this.f13154h.avatar, 10, false, false);
            }
            if (!k.isEmpty(this.f13154h.name)) {
                this.f13152f.setText(this.f13154h.name + " " + getContext().getResources().getString(R.string.smart_app_suffix));
            } else {
                this.f13152f.setText(getContext().getResources().getString(R.string.intelligent_smart_app));
            }
            if (!k.isEmpty(this.f13154h._abstract)) {
                this.f13153g.setText(this.f13154h._abstract);
            } else {
                this.f13153g.setText(getContext().getResources().getString(R.string.smart_app_default_abstract));
            }
            setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    public void d() {
        SkinManager.setBackgroundResource(this, R.drawable.applets_cell_bg);
        SkinManager.setViewTextColor(this.f13152f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f13153g, R.color.CAM_X0107);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SmartApp smartApp = this.f13154h;
        if (smartApp == null) {
            return;
        }
        if (!d.a.j0.s.a.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
            if (k.isEmpty(this.f13154h.h5_url)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(b(getContext()), new String[]{this.f13154h.h5_url});
        }
        View.OnClickListener onClickListener = this.f13155i;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.f13155i = onClickListener;
    }

    public ThreadSmartAppLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadSmartAppLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        LayoutInflater.from(context).inflate(R.layout.thread_smart_app_layout, (ViewGroup) this, true);
        HeadImageView headImageView = (HeadImageView) findViewById(R.id.iv_thread_smart_app_head);
        this.f13151e = headImageView;
        headImageView.setIsRound(true);
        this.f13151e.setPlaceHolder(1);
        this.f13152f = (TextView) findViewById(R.id.tv_thread_smart_app_title);
        this.f13153g = (TextView) findViewById(R.id.tv_thread_smart_app_abstract);
        setOnClickListener(this);
        d();
    }
}
