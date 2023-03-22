package com.baidu.nadcore.download.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.dk0;
import com.baidu.tieba.qh0;
import com.baidu.tieba.yi0;
import com.baidu.tieba.yp0;
/* loaded from: classes2.dex */
public class AdDownloadDlgView extends RelativeLayout {
    public ImageView a;
    public AdImageView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public FrameLayout j;
    public final View.OnClickListener k;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            if (!(AdDownloadDlgView.this.getTag() instanceof yp0)) {
                return;
            }
            yp0 yp0Var = (yp0) AdDownloadDlgView.this.getTag();
            int id = view2.getId();
            if (id == R.id.nad_download_lp_dlg_privacy) {
                yp0.b bVar = yp0Var.g;
                if (bVar != null) {
                    str = bVar.b;
                }
                str = "";
            } else {
                if (id == R.id.nad_download_lp_dlg_permission) {
                    yp0.a aVar = yp0Var.h;
                    if (aVar != null) {
                        str = aVar.b;
                    }
                } else if (id == R.id.nad_download_lp_dlg_dev_name && !TextUtils.isEmpty(yp0Var.d)) {
                    AdDownloadDlgView.this.d(yp0Var.d);
                    return;
                }
                str = "";
            }
            qh0.c(yi0.a().a(str), AdDownloadDlgView.this.getContext());
        }
    }

    public AdDownloadDlgView(@NonNull Context context) {
        this(context, null);
    }

    public void setDownloadView(View view2) {
        if (view2.getParent() instanceof ViewGroup) {
            ((ViewGroup) view2.getParent()).removeView(view2);
        }
        this.j.addView(view2);
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        this.a.setOnClickListener(onClickListener);
    }

    public AdDownloadDlgView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = new a();
        c(context);
    }

    public void b(dk0 dk0Var) {
        int i = 8;
        if (dk0Var != null && dk0Var.b != null) {
            this.i.setText(dk0Var.c);
            TextView textView = this.i;
            if (dk0Var.a != 2) {
                i = 0;
            }
            textView.setVisibility(i);
            yp0 yp0Var = dk0Var.b;
            setTag(yp0Var);
            this.b.o(yp0Var.b);
            this.c.setText(yp0Var.c);
            this.d.setText(yp0Var.i);
            this.e.setText(yp0Var.d);
            this.e.setOnClickListener(this.k);
            this.f.setText(yp0Var.f);
            yp0.b bVar = yp0Var.g;
            if (bVar != null && !TextUtils.isEmpty(bVar.b) && !TextUtils.isEmpty(bVar.a)) {
                this.g.setText(bVar.a);
                this.g.setOnClickListener(this.k);
            }
            yp0.a aVar = yp0Var.h;
            if (aVar != null && !TextUtils.isEmpty(aVar.b) && !TextUtils.isEmpty(aVar.a)) {
                this.h.setText(aVar.a);
                this.h.setOnClickListener(this.k);
                return;
            }
            return;
        }
        setVisibility(8);
    }

    public final void c(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.nad_download_lp_dlg, this);
        this.a = (ImageView) inflate.findViewById(R.id.nad_download_lp_dlg_close);
        this.b = (AdImageView) inflate.findViewById(R.id.nad_download_lp_dlg_logo);
        this.c = (TextView) inflate.findViewById(R.id.nad_download_lp_dlg_app_name);
        this.d = (TextView) inflate.findViewById(R.id.nad_download_lp_dlg_app_size);
        this.e = (TextView) inflate.findViewById(R.id.nad_download_lp_dlg_dev_name);
        this.f = (TextView) inflate.findViewById(R.id.nad_download_lp_dlg_app_version);
        this.g = (TextView) inflate.findViewById(R.id.nad_download_lp_dlg_privacy);
        this.h = (TextView) inflate.findViewById(R.id.nad_download_lp_dlg_permission);
        this.i = (TextView) inflate.findViewById(R.id.nad_download_lp_dlg_tip);
        this.j = (FrameLayout) inflate.findViewById(R.id.nad_download_lp_dlg_container);
    }

    public final void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.nad_download_lp_long_txt, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.nad_download_long_txt_view)).setText(str);
        Toast toast = new Toast(getContext());
        toast.setGravity(81, 0, (int) getContext().getResources().getDimension(R.dimen.nad_dimens_22dp));
        toast.setView(inflate);
        toast.show();
    }
}
