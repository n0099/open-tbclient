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
import d.a.n0.r.q.a;
import tbclient.SmartApp;
/* loaded from: classes3.dex */
public class ThreadSmartAppLayout extends RelativeLayout implements View.OnClickListener, p<a> {

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f12539e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f12540f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12541g;

    /* renamed from: h  reason: collision with root package name */
    public SmartApp f12542h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f12543i;

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
        if (aVar != null && aVar.i() != null && aVar.i().l1() != null) {
            SmartApp l1 = aVar.i().l1();
            this.f12542h = l1;
            if (!k.isEmpty(l1.avatar)) {
                this.f12539e.V(this.f12542h.avatar, 10, false, false);
            }
            if (!k.isEmpty(this.f12542h.name)) {
                this.f12540f.setText(this.f12542h.name + " " + getContext().getResources().getString(R.string.smart_app_suffix));
            } else {
                this.f12540f.setText(getContext().getResources().getString(R.string.intelligent_smart_app));
            }
            if (!k.isEmpty(this.f12542h._abstract)) {
                this.f12541g.setText(this.f12542h._abstract);
            } else {
                this.f12541g.setText(getContext().getResources().getString(R.string.smart_app_default_abstract));
            }
            setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    public void d() {
        SkinManager.setBackgroundResource(this, R.drawable.applets_cell_bg);
        SkinManager.setViewTextColor(this.f12540f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f12541g, R.color.CAM_X0107);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SmartApp smartApp = this.f12542h;
        if (smartApp == null) {
            return;
        }
        if (!d.a.o0.u.a.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
            if (k.isEmpty(this.f12542h.h5_url)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(b(getContext()), new String[]{this.f12542h.h5_url});
        }
        View.OnClickListener onClickListener = this.f12543i;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.f12543i = onClickListener;
    }

    public ThreadSmartAppLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThreadSmartAppLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        LayoutInflater.from(context).inflate(R.layout.thread_smart_app_layout, (ViewGroup) this, true);
        HeadImageView headImageView = (HeadImageView) findViewById(R.id.iv_thread_smart_app_head);
        this.f12539e = headImageView;
        headImageView.setIsRound(true);
        this.f12539e.setPlaceHolder(1);
        this.f12540f = (TextView) findViewById(R.id.tv_thread_smart_app_title);
        this.f12541g = (TextView) findViewById(R.id.tv_thread_smart_app_abstract);
        setOnClickListener(this);
        d();
    }
}
