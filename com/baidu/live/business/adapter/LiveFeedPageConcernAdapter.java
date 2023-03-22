package com.baidu.live.business.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LiveFollowEntity;
import com.baidu.live.business.model.data.LiveHostInfo;
import com.baidu.live.business.util.LiveBaseLottieView;
import com.baidu.tieba.R;
import com.baidu.tieba.i90;
import com.baidu.tieba.kb0;
import com.baidu.tieba.nb0;
import com.baidu.tieba.vb0;
import com.baidu.tieba.zb0;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class LiveFeedPageConcernAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public LayoutInflater a;
    public int c;
    public Context d;
    public String e;
    public boolean f;
    public boolean g;
    public d i;
    public List<LiveFollowEntity> b = new ArrayList();
    public String h = zb0.f().r();

    /* loaded from: classes2.dex */
    public interface d {
        void a(LiveFollowEntity liveFollowEntity, int i);

        void b(LiveFollowEntity liveFollowEntity, int i);
    }

    /* loaded from: classes2.dex */
    public static abstract class BaseFollowViewHolder extends RecyclerView.ViewHolder {
        public abstract void a(Context context);

        public BaseFollowViewHolder(@NonNull View view2) {
            super(view2);
        }
    }

    /* loaded from: classes2.dex */
    public static class OneFollowViewHolder extends BaseFollowViewHolder {
        public TextView a;
        public TextView b;
        public TextView c;
        public LiveBaseLottieView d;
        public SimpleDraweeView e;
        public LinearLayout f;
        public LinearLayout g;
        public String h;

        public OneFollowViewHolder(View view2, String str, String str2) {
            super(view2);
            this.h = "";
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925aa);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925ab);
            this.d = (LiveBaseLottieView) view2.findViewById(R.id.obfuscated_res_0x7f09031a);
            this.e = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f090319);
            this.f = (LinearLayout) view2.findViewById(R.id.right_container);
            this.g = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0916d2);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0916e4);
            this.h = str;
            LiveFeedPageConcernAdapter.h(this.d, str2);
            this.d.setRepeatCount(-1);
            a(view2.getContext());
        }

        @Override // com.baidu.live.business.adapter.LiveFeedPageConcernAdapter.BaseFollowViewHolder
        public void a(Context context) {
            vb0.h(this.a, 1, 14.0f);
            vb0.h(this.b, 1, 14.0f);
            vb0.f(this.e, i90.b(context, 24.0f), i90.b(context, 23.0f));
            vb0.f(this.d, i90.b(context, 33.0f), i90.b(context, 32.0f));
            vb0.h(this.c, 1, 12.0f);
            ViewGroup.LayoutParams layoutParams = this.g.getLayoutParams();
            layoutParams.height = vb0.c(i90.b(context, 32.0f));
            this.g.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes2.dex */
    public static class TwoFollowViewHolder extends BaseFollowViewHolder {
        public LinearLayout a;
        public TextView b;
        public LiveBaseLottieView c;
        public SimpleDraweeView d;
        public TextView e;
        public TextView f;
        public TextView g;
        public LinearLayout h;
        public String i;
        public String j;

        public TwoFollowViewHolder(View view2, String str, String str2) {
            super(view2);
            this.i = "";
            this.a = (LinearLayout) view2.findViewById(R.id.root_container);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925aa);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09031f);
            this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b29);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925a9);
            this.c = (LiveBaseLottieView) view2.findViewById(R.id.obfuscated_res_0x7f09031a);
            this.d = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f090319);
            this.h = (LinearLayout) view2.findViewById(R.id.right_container);
            this.i = str;
            this.j = str2;
            LiveFeedPageConcernAdapter.h(this.c, str2);
            this.c.setRepeatCount(-1);
            a(view2.getContext());
        }

        @Override // com.baidu.live.business.adapter.LiveFeedPageConcernAdapter.BaseFollowViewHolder
        public void a(Context context) {
            vb0.h(this.b, 1, 12.0f);
            vb0.h(this.e, 1, 9.0f);
            vb0.h(this.g, 1, 10.0f);
            vb0.h(this.f, 1, 11.0f);
            vb0.f(this.d, i90.b(context, 30.0f), i90.b(context, 30.0f));
            vb0.f(this.c, i90.b(context, 41.0f), i90.b(context, 41.0f));
            ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
            layoutParams.height = vb0.c(i90.b(context, 41.0f));
            this.f.setLayoutParams(layoutParams);
        }

        public final void c(Context context) {
            if (!LiveFeedPageSdk.IMMERSION.equals(this.j) && !LiveFeedPageSdk.VIDEO_BAR.equals(this.j) && !LiveFeedPageSdk.FOLLOW_VIDEO.equals(this.j)) {
                if (!LiveFeedPageSdk.UI_MODE_NIGHT.equals(zb0.f().r()) && !"dark".equals(zb0.f().r())) {
                    this.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d79);
                } else {
                    this.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d7a);
                }
            } else {
                this.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d7b);
            }
            if (LiveFeedPageSdk.VIDEO_BAR.equals(this.j) || LiveFeedPageSdk.FOLLOW_VIDEO.equals(this.j)) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                int b = i90.b(context, 13.0f);
                layoutParams.width = ((i90.e(context) - (b * 2)) - i90.b(context, 7.0f)) / 2;
                this.a.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.h.getLayoutParams();
                layoutParams2.width = -1;
                this.h.setLayoutParams(layoutParams2);
            }
            this.d.getHierarchy().setPlaceholderImage(zb0.f().l(this.j), ScalingUtils.ScaleType.FIT_XY);
            if (LiveFeedPageSdk.IMMERSION.equals(this.j) || LiveFeedPageSdk.VIDEO_BAR.equals(this.j)) {
                this.d.getHierarchy().setUseGlobalColorFilter(false);
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(zb0.f().a(context, this.j, "color_FF3333"));
            gradientDrawable.setCornerRadius(1000.0f);
            gradientDrawable.setStroke(i90.b(context, 1.0f), zb0.f().a(context, this.j, "color_white1"));
            this.e.setBackgroundDrawable(gradientDrawable);
        }
    }

    /* loaded from: classes2.dex */
    public static class ViewHolder extends BaseFollowViewHolder {
        public TextView a;
        public LiveBaseLottieView b;
        public SimpleDraweeView c;
        public TextView d;
        public ImageView e;
        public String f;

        public ViewHolder(View view2, String str, String str2) {
            super(view2);
            this.f = "";
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925aa);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09031f);
            this.e = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090b29);
            this.b = (LiveBaseLottieView) view2.findViewById(R.id.obfuscated_res_0x7f09031a);
            this.c = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f090319);
            this.f = str;
            LiveFeedPageConcernAdapter.h(this.b, str2);
            this.b.setRepeatCount(-1);
            a(view2.getContext());
        }

        @Override // com.baidu.live.business.adapter.LiveFeedPageConcernAdapter.BaseFollowViewHolder
        public void a(Context context) {
            vb0.h(this.a, 1, 10.0f);
            vb0.h(this.d, 1, 10.0f);
            vb0.f(this.c, i90.b(context, 45.0f), i90.b(context, 45.0f));
            vb0.f(this.b, i90.b(context, 61.0f), i90.b(context, 61.0f));
            vb0.f(this.e, i90.b(context, 45.0f), i90.b(context, 45.0f));
        }
    }

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            LiveFeedPageSdk.liveLog("FollowItemClick: position: " + this.a);
            int i = this.a;
            if (i >= 0 && i < LiveFeedPageConcernAdapter.this.b.size() && LiveFeedPageConcernAdapter.this.b.get(this.a) != null) {
                LiveFeedPageSdk.liveLog("FollowItemClick: scheme: " + ((LiveFollowEntity) LiveFeedPageConcernAdapter.this.b.get(this.a)).cmd);
                LiveFollowEntity liveFollowEntity = (LiveFollowEntity) LiveFeedPageConcernAdapter.this.b.get(this.a);
                d dVar = LiveFeedPageConcernAdapter.this.i;
                if (dVar != null) {
                    dVar.b(liveFollowEntity, this.a);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            LiveFeedPageSdk.liveLog("FollowItemClick: position: " + this.a);
            int i = this.a;
            if (i >= 0 && i < LiveFeedPageConcernAdapter.this.b.size() && LiveFeedPageConcernAdapter.this.b.get(this.a) != null) {
                LiveFeedPageSdk.liveLog("FollowItemClick: scheme: " + ((LiveFollowEntity) LiveFeedPageConcernAdapter.this.b.get(this.a)).cmd);
                LiveFollowEntity liveFollowEntity = (LiveFollowEntity) LiveFeedPageConcernAdapter.this.b.get(this.a);
                d dVar = LiveFeedPageConcernAdapter.this.i;
                if (dVar != null) {
                    dVar.b(liveFollowEntity, this.a);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public final /* synthetic */ int a;

        public c(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            LiveFeedPageSdk.liveLog("FollowItemClick: position: " + this.a);
            int i = this.a;
            if (i >= 0 && i < LiveFeedPageConcernAdapter.this.b.size() && LiveFeedPageConcernAdapter.this.b.get(this.a) != null) {
                LiveFeedPageSdk.liveLog("FollowItemClick: scheme: " + ((LiveFollowEntity) LiveFeedPageConcernAdapter.this.b.get(this.a)).cmd);
                LiveFollowEntity liveFollowEntity = (LiveFollowEntity) LiveFeedPageConcernAdapter.this.b.get(this.a);
                d dVar = LiveFeedPageConcernAdapter.this.i;
                if (dVar != null) {
                    dVar.b(liveFollowEntity, this.a);
                }
            }
        }
    }

    public LiveFeedPageConcernAdapter(Context context, String str) {
        this.d = context;
        this.e = str;
        this.a = LayoutInflater.from(context);
    }

    public void j(List<LiveFollowEntity> list, int i) {
        if (kb0.c(list)) {
            return;
        }
        List<LiveFollowEntity> list2 = this.b;
        if (list2 != null) {
            list2.clear();
        } else {
            this.b = new ArrayList();
        }
        this.b.addAll(list);
        this.c = i;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (g() == 1) {
            return 1;
        }
        if (g() == 2) {
            return 2;
        }
        return 3;
    }

    public void k(d dVar) {
        this.i = dVar;
    }

    public void l(boolean z) {
        this.f = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        m(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        f(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        f(viewHolder);
    }

    public static void h(LiveBaseLottieView liveBaseLottieView, String str) {
        if (liveBaseLottieView != null) {
            if (!LiveFeedPageSdk.IMMERSION.equals(str) && !LiveFeedPageSdk.VIDEO_BAR.equals(str)) {
                if (!LiveFeedPageSdk.UI_MODE_NIGHT.equals(zb0.f().r()) && !"dark".equals(zb0.f().r())) {
                    liveBaseLottieView.setAnimationFromUrl("https://ala-rmb-gift.bj.bcebos.com/lottie/common/live_feed_page_shinning.json");
                    return;
                } else {
                    liveBaseLottieView.setAnimationFromUrl("https://ala-rmb-gift.bj.bcebos.com/lottie/common/live_feed_page_shinning_night.json");
                    return;
                }
            }
            liveBaseLottieView.setAnimationFromUrl("https://ala-rmb-gift.bj.bcebos.com/lottie/common/live_feed_page_shinning.json");
        }
    }

    public final void f(@NonNull RecyclerView.ViewHolder viewHolder) {
        if ((viewHolder instanceof OneFollowViewHolder) && this.g) {
            OneFollowViewHolder oneFollowViewHolder = (OneFollowViewHolder) viewHolder;
            LiveBaseLottieView liveBaseLottieView = oneFollowViewHolder.d;
            if (liveBaseLottieView != null && liveBaseLottieView.isAnimating()) {
                oneFollowViewHolder.d.cancelAnimation();
            }
        } else if ((viewHolder instanceof TwoFollowViewHolder) && this.g) {
            TwoFollowViewHolder twoFollowViewHolder = (TwoFollowViewHolder) viewHolder;
            LiveBaseLottieView liveBaseLottieView2 = twoFollowViewHolder.c;
            if (liveBaseLottieView2 != null && liveBaseLottieView2.isAnimating()) {
                twoFollowViewHolder.c.cancelAnimation();
            }
        } else {
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            LiveBaseLottieView liveBaseLottieView3 = viewHolder2.b;
            if (liveBaseLottieView3 != null && liveBaseLottieView3.isAnimating()) {
                viewHolder2.b.cancelAnimation();
            }
        }
    }

    public int g() {
        return this.c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    public void i() {
        if (!kb0.c(this.b)) {
            this.b.clear();
        }
        notifyDataSetChanged();
    }

    public final void m(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (g() == 1 && this.g) {
            OneFollowViewHolder oneFollowViewHolder = (OneFollowViewHolder) viewHolder;
            LiveBaseLottieView liveBaseLottieView = oneFollowViewHolder.d;
            if (liveBaseLottieView != null && liveBaseLottieView.getVisibility() == 0 && !oneFollowViewHolder.d.isAnimating()) {
                oneFollowViewHolder.d.playAnimation();
            }
        } else if (g() == 2 && this.g) {
            TwoFollowViewHolder twoFollowViewHolder = (TwoFollowViewHolder) viewHolder;
            LiveBaseLottieView liveBaseLottieView2 = twoFollowViewHolder.c;
            if (liveBaseLottieView2 != null && liveBaseLottieView2.getVisibility() == 0 && !twoFollowViewHolder.c.isAnimating()) {
                twoFollowViewHolder.c.playAnimation();
            }
        } else {
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            LiveBaseLottieView liveBaseLottieView3 = viewHolder2.b;
            if (liveBaseLottieView3 != null && liveBaseLottieView3.getVisibility() == 0 && !viewHolder2.b.isAnimating()) {
                viewHolder2.b.playAnimation();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (LiveFeedPageSdk.FOLLOW_VIDEO.equals(this.e)) {
            if (i == 0) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewHolder.itemView.getLayoutParams();
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i90.b(this.d, 13.0f);
                viewHolder.itemView.setLayoutParams(layoutParams);
            } else {
                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) viewHolder.itemView.getLayoutParams();
                ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = i90.b(this.d, 0.0f);
                viewHolder.itemView.setLayoutParams(layoutParams2);
            }
        }
        if (viewHolder instanceof BaseFollowViewHolder) {
            ((BaseFollowViewHolder) viewHolder).a(this.d);
        }
        if (getItemViewType(i) == 1 && this.g && (viewHolder instanceof OneFollowViewHolder)) {
            OneFollowViewHolder oneFollowViewHolder = (OneFollowViewHolder) viewHolder;
            LiveFollowEntity liveFollowEntity = (LiveFollowEntity) kb0.b(this.b, i);
            if (liveFollowEntity != null) {
                if (liveFollowEntity.needLogShow) {
                    d dVar = this.i;
                    if (dVar != null) {
                        dVar.a(liveFollowEntity, i);
                    }
                    liveFollowEntity.needLogShow = false;
                }
                if (liveFollowEntity.isMore) {
                    f(oneFollowViewHolder);
                    oneFollowViewHolder.e.setVisibility(8);
                    oneFollowViewHolder.d.setVisibility(8);
                    oneFollowViewHolder.f.setVisibility(8);
                    oneFollowViewHolder.g.setVisibility(0);
                    LiveHostInfo liveHostInfo = liveFollowEntity.hostInfo;
                    if (liveHostInfo != null) {
                        if (nb0.a(liveHostInfo.name)) {
                            oneFollowViewHolder.c.setText(R.string.obfuscated_res_0x7f0f0ac3);
                        } else {
                            oneFollowViewHolder.c.setText(liveFollowEntity.hostInfo.name);
                        }
                        oneFollowViewHolder.c.setTextColor(zb0.f().a(this.d, this.e, "color_858585"));
                        oneFollowViewHolder.c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ResourcesCompat.getDrawable(oneFollowViewHolder.itemView.getContext().getResources(), zb0.f().e(this.e), null), (Drawable) null);
                    }
                } else {
                    oneFollowViewHolder.f.setVisibility(0);
                    oneFollowViewHolder.g.setVisibility(8);
                    oneFollowViewHolder.e.setVisibility(0);
                    oneFollowViewHolder.d.setVisibility(0);
                    LiveHostInfo liveHostInfo2 = liveFollowEntity.hostInfo;
                    if (liveHostInfo2 != null) {
                        oneFollowViewHolder.e.setImageURI(liveHostInfo2.avatar);
                    }
                }
                LiveHostInfo liveHostInfo3 = liveFollowEntity.hostInfo;
                if (liveHostInfo3 != null) {
                    oneFollowViewHolder.e.setImageURI(liveHostInfo3.avatar);
                }
                LiveHostInfo liveHostInfo4 = liveFollowEntity.hostInfo;
                if (liveHostInfo4 != null) {
                    if (!nb0.a(liveHostInfo4.name)) {
                        oneFollowViewHolder.a.setText(liveFollowEntity.hostInfo.name);
                    }
                    oneFollowViewHolder.a.setTextColor(zb0.f().a(this.d, this.e, "color_1F1F1F"));
                    oneFollowViewHolder.b.setTextColor(zb0.f().a(this.d, this.e, "color_1F1F1F"));
                }
                oneFollowViewHolder.itemView.setOnClickListener(new a(i));
                oneFollowViewHolder.e.getHierarchy().setPlaceholderImage(zb0.f().l(this.e), ScalingUtils.ScaleType.FIT_XY);
                if (LiveFeedPageSdk.IMMERSION.equals(this.e) || "recommend".equals(this.e) || LiveFeedPageSdk.VIDEO_BAR.equals(this.e)) {
                    oneFollowViewHolder.e.getHierarchy().setUseGlobalColorFilter(false);
                }
                this.h = zb0.f().r();
                if (!nb0.a(oneFollowViewHolder.h) && !oneFollowViewHolder.h.equals(this.h)) {
                    oneFollowViewHolder.h = this.h;
                    if (oneFollowViewHolder.d.isAnimating()) {
                        oneFollowViewHolder.d.cancelAnimation();
                    }
                    h(oneFollowViewHolder.d, this.e);
                }
            }
        } else if (getItemViewType(i) == 2 && this.g && (viewHolder instanceof TwoFollowViewHolder)) {
            TwoFollowViewHolder twoFollowViewHolder = (TwoFollowViewHolder) viewHolder;
            twoFollowViewHolder.c(this.d);
            LiveFollowEntity liveFollowEntity2 = (LiveFollowEntity) kb0.b(this.b, i);
            if (liveFollowEntity2 != null) {
                if (liveFollowEntity2.needLogShow) {
                    d dVar2 = this.i;
                    if (dVar2 != null) {
                        dVar2.a(liveFollowEntity2, i);
                    }
                    liveFollowEntity2.needLogShow = false;
                }
                if (liveFollowEntity2.isMore) {
                    f(twoFollowViewHolder);
                    twoFollowViewHolder.f.setVisibility(0);
                    LiveHostInfo liveHostInfo5 = liveFollowEntity2.hostInfo;
                    if (liveHostInfo5 != null) {
                        if (nb0.a(liveHostInfo5.name)) {
                            twoFollowViewHolder.f.setText(R.string.obfuscated_res_0x7f0f0ac3);
                        } else {
                            twoFollowViewHolder.f.setText(liveFollowEntity2.hostInfo.name);
                        }
                    }
                    twoFollowViewHolder.f.setTextColor(zb0.f().a(this.d, this.e, "color_1F1F1F"));
                    twoFollowViewHolder.c.setVisibility(8);
                    twoFollowViewHolder.e.setVisibility(8);
                    twoFollowViewHolder.d.setVisibility(8);
                    twoFollowViewHolder.h.setVisibility(8);
                } else {
                    twoFollowViewHolder.f.setVisibility(8);
                    twoFollowViewHolder.c.setVisibility(0);
                    twoFollowViewHolder.e.setVisibility(0);
                    twoFollowViewHolder.d.setVisibility(0);
                    twoFollowViewHolder.h.setVisibility(0);
                    if (!TextUtils.isEmpty(liveFollowEntity2.liveTag)) {
                        twoFollowViewHolder.g.setVisibility(0);
                        twoFollowViewHolder.g.setText(liveFollowEntity2.liveTag);
                        twoFollowViewHolder.g.setTextColor(zb0.f().a(this.d, this.e, "color_858585"));
                    } else {
                        twoFollowViewHolder.g.setVisibility(8);
                    }
                    LiveHostInfo liveHostInfo6 = liveFollowEntity2.hostInfo;
                    if (liveHostInfo6 != null) {
                        twoFollowViewHolder.d.setImageURI(liveHostInfo6.avatar);
                    }
                    twoFollowViewHolder.e.setTextColor(zb0.f().a(this.d, this.e, "color_white3"));
                }
                LiveHostInfo liveHostInfo7 = liveFollowEntity2.hostInfo;
                if (liveHostInfo7 != null) {
                    if (!nb0.a(liveHostInfo7.name)) {
                        twoFollowViewHolder.b.setText(liveFollowEntity2.hostInfo.name);
                    }
                    twoFollowViewHolder.b.setTextColor(zb0.f().a(this.d, this.e, "color_1F1F1F"));
                }
                twoFollowViewHolder.itemView.setOnClickListener(new b(i));
                this.h = zb0.f().r();
                if (!nb0.a(twoFollowViewHolder.i) && !twoFollowViewHolder.i.equals(this.h)) {
                    twoFollowViewHolder.i = this.h;
                    if (twoFollowViewHolder.c.isAnimating()) {
                        twoFollowViewHolder.c.cancelAnimation();
                    }
                    h(twoFollowViewHolder.c, this.e);
                }
            }
        } else if (viewHolder instanceof ViewHolder) {
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            LiveFollowEntity liveFollowEntity3 = (LiveFollowEntity) kb0.b(this.b, i);
            if (liveFollowEntity3 != null) {
                if (liveFollowEntity3.needLogShow) {
                    d dVar3 = this.i;
                    if (dVar3 != null) {
                        dVar3.a(liveFollowEntity3, i);
                    }
                    liveFollowEntity3.needLogShow = false;
                }
                if (liveFollowEntity3.isMore) {
                    f(viewHolder2);
                    if (!LiveFeedPageSdk.IMMERSION.equals(this.e) && !LiveFeedPageSdk.VIDEO_BAR.equals(this.e)) {
                        if (!LiveFeedPageSdk.UI_MODE_NIGHT.equals(zb0.f().r()) && !"dark".equals(zb0.f().r())) {
                            viewHolder2.e.setImageResource(R.drawable.obfuscated_res_0x7f080d6e);
                        } else {
                            viewHolder2.e.setImageResource(R.drawable.obfuscated_res_0x7f080d70);
                        }
                    } else {
                        viewHolder2.e.setImageResource(R.drawable.obfuscated_res_0x7f080d6f);
                    }
                    viewHolder2.e.setVisibility(0);
                    viewHolder2.b.setVisibility(4);
                    viewHolder2.d.setVisibility(8);
                    viewHolder2.c.setVisibility(8);
                } else {
                    viewHolder2.e.setVisibility(8);
                    viewHolder2.b.setVisibility(0);
                    viewHolder2.d.setVisibility(0);
                    viewHolder2.c.setVisibility(0);
                    LiveHostInfo liveHostInfo8 = liveFollowEntity3.hostInfo;
                    if (liveHostInfo8 != null) {
                        viewHolder2.c.setImageURI(liveHostInfo8.avatar);
                    }
                    viewHolder2.d.setTextColor(zb0.f().a(this.d, this.e, "color_white3"));
                }
                LiveHostInfo liveHostInfo9 = liveFollowEntity3.hostInfo;
                if (liveHostInfo9 != null) {
                    if (nb0.a(liveHostInfo9.name)) {
                        viewHolder2.a.setText(R.string.obfuscated_res_0x7f0f0ac3);
                    } else {
                        viewHolder2.a.setText(liveFollowEntity3.hostInfo.name);
                    }
                    viewHolder2.a.setTextColor(zb0.f().a(this.d, this.e, "color_1F1F1F"));
                }
                viewHolder2.itemView.setOnClickListener(new c(i));
                viewHolder2.c.getHierarchy().setPlaceholderImage(zb0.f().l(this.e), ScalingUtils.ScaleType.FIT_XY);
                if (LiveFeedPageSdk.IMMERSION.equals(this.e) || LiveFeedPageSdk.VIDEO_BAR.equals(this.e)) {
                    viewHolder2.c.getHierarchy().setUseGlobalColorFilter(false);
                }
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(zb0.f().a(this.d, this.e, "color_FF3333"));
                gradientDrawable.setCornerRadius(1000.0f);
                gradientDrawable.setStroke(i90.b(this.d, 1.0f), zb0.f().a(this.d, this.e, "color_white1"));
                viewHolder2.d.setBackgroundDrawable(gradientDrawable);
                this.h = zb0.f().r();
                if (!nb0.a(viewHolder2.f) && !viewHolder2.f.equals(this.h)) {
                    viewHolder2.f = this.h;
                    if (viewHolder2.b.isAnimating()) {
                        viewHolder2.b.cancelAnimation();
                    }
                    h(viewHolder2.b, this.e);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.f) {
            this.g = true;
        }
        if (getItemViewType(i) == 1 && this.g) {
            return new OneFollowViewHolder(this.a.inflate(R.layout.obfuscated_res_0x7f0d0587, viewGroup, false), this.h, this.e);
        }
        if (getItemViewType(i) == 2 && this.g) {
            return new TwoFollowViewHolder(this.a.inflate(R.layout.obfuscated_res_0x7f0d0596, viewGroup, false), this.h, this.e);
        }
        return new ViewHolder(this.a.inflate(R.layout.obfuscated_res_0x7f0d057f, viewGroup, false), this.h, this.e);
    }
}
