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
import com.baidu.tieba.bl0;
import com.baidu.tieba.bs0;
import com.baidu.tieba.gm0;
import com.baidu.tieba.tj0;
/* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            if (!(AdDownloadDlgView.this.getTag() instanceof bs0)) {
                return;
            }
            bs0 bs0Var = (bs0) AdDownloadDlgView.this.getTag();
            int id = view2.getId();
            if (id == R.id.nad_download_lp_dlg_privacy) {
                bs0.b bVar = bs0Var.g;
                if (bVar != null) {
                    str = bVar.b;
                }
                str = "";
            } else {
                if (id == R.id.nad_download_lp_dlg_permission) {
                    bs0.a aVar = bs0Var.h;
                    if (aVar != null) {
                        str = aVar.b;
                    }
                } else if (id == R.id.nad_download_lp_dlg_dev_name && !TextUtils.isEmpty(bs0Var.d)) {
                    AdDownloadDlgView.this.d(bs0Var.d);
                    return;
                }
                str = "";
            }
            tj0.c(bl0.a().a(str), AdDownloadDlgView.this.getContext());
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

    public void b(gm0 gm0Var) {
        int i = 8;
        if (gm0Var != null && gm0Var.b != null) {
            this.i.setText(gm0Var.c);
            TextView textView = this.i;
            if (gm0Var.a != 2) {
                i = 0;
            }
            textView.setVisibility(i);
            bs0 bs0Var = gm0Var.b;
            setTag(bs0Var);
            this.b.o(bs0Var.b);
            this.c.setText(bs0Var.c);
            this.d.setText(bs0Var.i);
            this.e.setText(bs0Var.d);
            this.e.setOnClickListener(this.k);
            this.f.setText(bs0Var.f);
            bs0.b bVar = bs0Var.g;
            if (bVar != null && !TextUtils.isEmpty(bVar.b) && !TextUtils.isEmpty(bVar.a)) {
                this.g.setText(bVar.a);
                this.g.setOnClickListener(this.k);
            }
            bs0.a aVar = bs0Var.h;
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
