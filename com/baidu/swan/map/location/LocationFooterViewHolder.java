package com.baidu.swan.map.location;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class LocationFooterViewHolder extends RecyclerView.ViewHolder {
    public TextView a;
    public ProgressBar b;

    public LocationFooterViewHolder(View view2) {
        super(view2);
        a(view2);
    }

    public final void a(View view2) {
        this.a = (TextView) view2.findViewById(R.id.loading_text);
        this.b = (ProgressBar) view2.findViewById(R.id.obfuscated_res_0x7f09165c);
    }

    public void b(boolean z) {
        int i;
        View view2 = this.itemView;
        if (z) {
            i = 0;
        } else {
            i = 4;
        }
        view2.setVisibility(i);
    }
}
