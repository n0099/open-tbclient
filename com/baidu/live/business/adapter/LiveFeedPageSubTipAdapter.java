package com.baidu.live.business.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.tieba.R;
import com.baidu.tieba.ca0;
import com.baidu.tieba.ec0;
import com.baidu.tieba.tc0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class LiveFeedPageSubTipAdapter extends RecyclerView.Adapter<ViewHolder> {
    public LayoutInflater a;
    public Context c;
    public String d;
    public float[] f;
    public b g;
    public List<LiveTabEntity.TabLabelInfo> b = new ArrayList();
    public int e = 0;

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view2, int i);
    }

    /* loaded from: classes3.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView a;

        public ViewHolder(View view2) {
            super(view2);
        }
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ ViewHolder a;

        public a(ViewHolder viewHolder) {
            this.a = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            LiveFeedPageSubTipAdapter.this.g.a(this.a.itemView, this.a.getLayoutPosition());
        }
    }

    public LiveFeedPageSubTipAdapter(Context context, String str) {
        this.c = context;
        this.d = str;
        this.a = LayoutInflater.from(context);
        float b2 = ca0.b(this.c, 14.0f);
        this.f = new float[]{b2, b2, b2, b2, b2, b2, b2, b2};
    }

    public int l(String str) {
        if (!ec0.c(this.b) && str != null) {
            for (int i = 0; i < this.b.size(); i++) {
                LiveTabEntity.TabLabelInfo tabLabelInfo = this.b.get(i);
                if (tabLabelInfo != null && str.equals(tabLabelInfo.type)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void r(b bVar) {
        this.g = bVar;
    }

    public void s(int i) {
        this.e = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    public int m() {
        return this.e;
    }

    public LiveTabEntity.TabLabelInfo n() {
        return (LiveTabEntity.TabLabelInfo) ec0.b(this.b, this.e);
    }

    public void q() {
        if (!ec0.c(this.b)) {
            this.b.clear();
        }
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        LiveTabEntity.TabLabelInfo tabLabelInfo = (LiveTabEntity.TabLabelInfo) ec0.b(this.b, i);
        if (tabLabelInfo != null) {
            viewHolder.a.setText(tabLabelInfo.name);
            if (this.g != null) {
                viewHolder.itemView.setOnClickListener(new a(viewHolder));
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadii(this.f);
            if (i == this.e) {
                viewHolder.a.setTextColor(tc0.f().a(this.c, this.d, "color_FF33551"));
                gradientDrawable.setColors(new int[]{tc0.f().a(this.c, this.d, "color_FF33552"), tc0.f().a(this.c, this.d, "color_FF33552")});
                viewHolder.a.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                viewHolder.a.setTextColor(tc0.f().a(this.c, this.d, "color_525252"));
                gradientDrawable.setColors(new int[]{tc0.f().a(this.c, this.d, "color_F5F5F53"), tc0.f().a(this.c, this.d, "color_F5F5F53")});
                viewHolder.a.setTypeface(Typeface.defaultFromStyle(0));
            }
            viewHolder.a.setBackgroundDrawable(gradientDrawable);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = this.a.inflate(R.layout.obfuscated_res_0x7f0d05b6, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        viewHolder.a = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092621);
        return viewHolder;
    }

    public void t(List<LiveTabEntity.TabLabelInfo> list, String str) {
        if (ec0.c(list)) {
            return;
        }
        List<LiveTabEntity.TabLabelInfo> list2 = this.b;
        if (list2 != null) {
            list2.clear();
        } else {
            this.b = new ArrayList();
        }
        this.b.addAll(list);
        this.e = 0;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.b.size(); i3++) {
            LiveTabEntity.TabLabelInfo tabLabelInfo = this.b.get(i3);
            if (tabLabelInfo != null) {
                if (!TextUtils.isEmpty(str) && i == 0 && str.equals(tabLabelInfo.type)) {
                    LiveFeedPageSdk.liveLog("Scheme指定找到了三级标签 = " + tabLabelInfo.name);
                    i = i3;
                }
                if (tabLabelInfo.selected && i2 == 0) {
                    i2 = i3;
                }
            }
        }
        if (i == 0) {
            i = i2;
        }
        this.e = i;
        notifyDataSetChanged();
    }
}
