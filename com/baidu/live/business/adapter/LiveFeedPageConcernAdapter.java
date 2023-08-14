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
import com.baidu.tieba.bd0;
import com.baidu.tieba.fd0;
import com.baidu.tieba.oa0;
import com.baidu.tieba.qc0;
import com.baidu.tieba.tc0;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class LiveFeedPageConcernAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public LayoutInflater a;
    public int c;
    public Context d;
    public String e;
    public boolean f;
    public boolean g;
    public d i;
    public List<LiveFollowEntity> b = new ArrayList();
    public String h = fd0.f().r();

    /* loaded from: classes3.dex */
    public interface d {
        void a(LiveFollowEntity liveFollowEntity, int i);

        void b(LiveFollowEntity liveFollowEntity, int i);
    }

    /* loaded from: classes3.dex */
    public static abstract class BaseFollowViewHolder extends RecyclerView.ViewHolder {
        public abstract void b(Context context);

        public BaseFollowViewHolder(@NonNull View view2) {
            super(view2);
        }
    }

    /* loaded from: classes3.dex */
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
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09271c);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09271d);
            this.d = (LiveBaseLottieView) view2.findViewById(R.id.obfuscated_res_0x7f09031c);
            this.e = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f09031b);
            this.f = (LinearLayout) view2.findViewById(R.id.right_container);
            this.g = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091789);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09179c);
            this.h = str;
            LiveFeedPageConcernAdapter.p(this.d, str2);
            this.d.setRepeatCount(-1);
            b(view2.getContext());
        }

        @Override // com.baidu.live.business.adapter.LiveFeedPageConcernAdapter.BaseFollowViewHolder
        public void b(Context context) {
            bd0.h(this.a, 1, 14.0f);
            bd0.h(this.b, 1, 14.0f);
            bd0.f(this.e, oa0.b(context, 24.0f), oa0.b(context, 23.0f));
            bd0.f(this.d, oa0.b(context, 33.0f), oa0.b(context, 32.0f));
            bd0.h(this.c, 1, 12.0f);
            ViewGroup.LayoutParams layoutParams = this.g.getLayoutParams();
            layoutParams.height = bd0.c(oa0.b(context, 32.0f));
            this.g.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes3.dex */
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
            this.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091f79);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09271c);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090321);
            this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b93);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09271b);
            this.c = (LiveBaseLottieView) view2.findViewById(R.id.obfuscated_res_0x7f09031c);
            this.d = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f09031b);
            this.h = (LinearLayout) view2.findViewById(R.id.right_container);
            this.i = str;
            this.j = str2;
            LiveFeedPageConcernAdapter.p(this.c, str2);
            this.c.setRepeatCount(-1);
            b(view2.getContext());
        }

        @Override // com.baidu.live.business.adapter.LiveFeedPageConcernAdapter.BaseFollowViewHolder
        public void b(Context context) {
            bd0.h(this.b, 1, 12.0f);
            bd0.h(this.e, 1, 9.0f);
            bd0.h(this.g, 1, 10.0f);
            bd0.h(this.f, 1, 11.0f);
            bd0.f(this.d, oa0.b(context, 30.0f), oa0.b(context, 30.0f));
            bd0.f(this.c, oa0.b(context, 41.0f), oa0.b(context, 41.0f));
            ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
            layoutParams.height = bd0.c(oa0.b(context, 41.0f));
            this.f.setLayoutParams(layoutParams);
        }

        public final void d(Context context) {
            if (!LiveFeedPageSdk.IMMERSION.equals(this.j) && !LiveFeedPageSdk.VIDEO_BAR.equals(this.j) && !LiveFeedPageSdk.FOLLOW_VIDEO.equals(this.j)) {
                if (!"night".equals(fd0.f().r()) && !"dark".equals(fd0.f().r())) {
                    this.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f080f14);
                } else {
                    this.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f080f15);
                }
            } else {
                this.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f080f16);
            }
            if (LiveFeedPageSdk.VIDEO_BAR.equals(this.j) || LiveFeedPageSdk.FOLLOW_VIDEO.equals(this.j)) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                int b = oa0.b(context, 13.0f);
                layoutParams.width = ((oa0.e(context) - (b * 2)) - oa0.b(context, 7.0f)) / 2;
                this.a.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.h.getLayoutParams();
                layoutParams2.width = -1;
                this.h.setLayoutParams(layoutParams2);
            }
            this.d.getHierarchy().setPlaceholderImage(fd0.f().l(this.j), ScalingUtils.ScaleType.FIT_XY);
            if (LiveFeedPageSdk.IMMERSION.equals(this.j) || LiveFeedPageSdk.VIDEO_BAR.equals(this.j)) {
                this.d.getHierarchy().setUseGlobalColorFilter(false);
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(fd0.f().a(context, this.j, "color_FF3333"));
            gradientDrawable.setCornerRadius(1000.0f);
            gradientDrawable.setStroke(oa0.b(context, 1.0f), fd0.f().a(context, this.j, "color_white1"));
            this.e.setBackgroundDrawable(gradientDrawable);
        }
    }

    /* loaded from: classes3.dex */
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
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09271c);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090321);
            this.e = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090b93);
            this.b = (LiveBaseLottieView) view2.findViewById(R.id.obfuscated_res_0x7f09031c);
            this.c = (SimpleDraweeView) view2.findViewById(R.id.obfuscated_res_0x7f09031b);
            this.f = str;
            LiveFeedPageConcernAdapter.p(this.b, str2);
            this.b.setRepeatCount(-1);
            b(view2.getContext());
        }

        @Override // com.baidu.live.business.adapter.LiveFeedPageConcernAdapter.BaseFollowViewHolder
        public void b(Context context) {
            bd0.h(this.a, 1, 10.0f);
            bd0.h(this.d, 1, 10.0f);
            bd0.f(this.c, oa0.b(context, 45.0f), oa0.b(context, 45.0f));
            bd0.f(this.b, oa0.b(context, 61.0f), oa0.b(context, 61.0f));
            bd0.f(this.e, oa0.b(context, 45.0f), oa0.b(context, 45.0f));
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    public void r(List<LiveFollowEntity> list, int i) {
        if (qc0.c(list)) {
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
        if (o() == 1) {
            return 1;
        }
        if (o() == 2) {
            return 2;
        }
        return 3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        u(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        n(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        n(viewHolder);
    }

    public void s(d dVar) {
        this.i = dVar;
    }

    public void t(boolean z) {
        this.f = z;
    }

    public static void p(LiveBaseLottieView liveBaseLottieView, String str) {
        if (liveBaseLottieView != null) {
            if (!LiveFeedPageSdk.IMMERSION.equals(str) && !LiveFeedPageSdk.VIDEO_BAR.equals(str)) {
                if (!"night".equals(fd0.f().r()) && !"dark".equals(fd0.f().r())) {
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

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    public int o() {
        return this.c;
    }

    public void q() {
        if (!qc0.c(this.b)) {
            this.b.clear();
        }
        notifyDataSetChanged();
    }

    public final void n(@NonNull RecyclerView.ViewHolder viewHolder) {
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

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (LiveFeedPageSdk.FOLLOW_VIDEO.equals(this.e)) {
            if (i == 0) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewHolder.itemView.getLayoutParams();
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = oa0.b(this.d, 13.0f);
                viewHolder.itemView.setLayoutParams(layoutParams);
            } else {
                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) viewHolder.itemView.getLayoutParams();
                ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = oa0.b(this.d, 0.0f);
                viewHolder.itemView.setLayoutParams(layoutParams2);
            }
        }
        if (viewHolder instanceof BaseFollowViewHolder) {
            ((BaseFollowViewHolder) viewHolder).b(this.d);
        }
        if (getItemViewType(i) == 1 && this.g && (viewHolder instanceof OneFollowViewHolder)) {
            OneFollowViewHolder oneFollowViewHolder = (OneFollowViewHolder) viewHolder;
            LiveFollowEntity liveFollowEntity = (LiveFollowEntity) qc0.b(this.b, i);
            if (liveFollowEntity != null) {
                if (liveFollowEntity.needLogShow) {
                    d dVar = this.i;
                    if (dVar != null) {
                        dVar.a(liveFollowEntity, i);
                    }
                    liveFollowEntity.needLogShow = false;
                }
                if (liveFollowEntity.isMore) {
                    n(oneFollowViewHolder);
                    oneFollowViewHolder.e.setVisibility(8);
                    oneFollowViewHolder.d.setVisibility(8);
                    oneFollowViewHolder.f.setVisibility(8);
                    oneFollowViewHolder.g.setVisibility(0);
                    LiveHostInfo liveHostInfo = liveFollowEntity.hostInfo;
                    if (liveHostInfo != null) {
                        if (tc0.a(liveHostInfo.name)) {
                            oneFollowViewHolder.c.setText(R.string.obfuscated_res_0x7f0f0ba1);
                        } else {
                            oneFollowViewHolder.c.setText(liveFollowEntity.hostInfo.name);
                        }
                        oneFollowViewHolder.c.setTextColor(fd0.f().a(this.d, this.e, "color_858585"));
                        oneFollowViewHolder.c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ResourcesCompat.getDrawable(oneFollowViewHolder.itemView.getContext().getResources(), fd0.f().e(this.e), null), (Drawable) null);
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
                    if (!tc0.a(liveHostInfo4.name)) {
                        oneFollowViewHolder.a.setText(liveFollowEntity.hostInfo.name);
                    }
                    oneFollowViewHolder.a.setTextColor(fd0.f().a(this.d, this.e, "color_1F1F1F"));
                    oneFollowViewHolder.b.setTextColor(fd0.f().a(this.d, this.e, "color_1F1F1F"));
                }
                oneFollowViewHolder.itemView.setOnClickListener(new a(i));
                oneFollowViewHolder.e.getHierarchy().setPlaceholderImage(fd0.f().l(this.e), ScalingUtils.ScaleType.FIT_XY);
                if (LiveFeedPageSdk.IMMERSION.equals(this.e) || "recommend".equals(this.e) || LiveFeedPageSdk.VIDEO_BAR.equals(this.e)) {
                    oneFollowViewHolder.e.getHierarchy().setUseGlobalColorFilter(false);
                }
                this.h = fd0.f().r();
                if (!tc0.a(oneFollowViewHolder.h) && !oneFollowViewHolder.h.equals(this.h)) {
                    oneFollowViewHolder.h = this.h;
                    if (oneFollowViewHolder.d.isAnimating()) {
                        oneFollowViewHolder.d.cancelAnimation();
                    }
                    p(oneFollowViewHolder.d, this.e);
                }
            }
        } else if (getItemViewType(i) == 2 && this.g && (viewHolder instanceof TwoFollowViewHolder)) {
            TwoFollowViewHolder twoFollowViewHolder = (TwoFollowViewHolder) viewHolder;
            twoFollowViewHolder.d(this.d);
            LiveFollowEntity liveFollowEntity2 = (LiveFollowEntity) qc0.b(this.b, i);
            if (liveFollowEntity2 != null) {
                if (liveFollowEntity2.needLogShow) {
                    d dVar2 = this.i;
                    if (dVar2 != null) {
                        dVar2.a(liveFollowEntity2, i);
                    }
                    liveFollowEntity2.needLogShow = false;
                }
                if (liveFollowEntity2.isMore) {
                    n(twoFollowViewHolder);
                    twoFollowViewHolder.f.setVisibility(0);
                    LiveHostInfo liveHostInfo5 = liveFollowEntity2.hostInfo;
                    if (liveHostInfo5 != null) {
                        if (tc0.a(liveHostInfo5.name)) {
                            twoFollowViewHolder.f.setText(R.string.obfuscated_res_0x7f0f0ba1);
                        } else {
                            twoFollowViewHolder.f.setText(liveFollowEntity2.hostInfo.name);
                        }
                    }
                    twoFollowViewHolder.f.setTextColor(fd0.f().a(this.d, this.e, "color_1F1F1F"));
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
                        twoFollowViewHolder.g.setTextColor(fd0.f().a(this.d, this.e, "color_858585"));
                    } else {
                        twoFollowViewHolder.g.setVisibility(8);
                    }
                    LiveHostInfo liveHostInfo6 = liveFollowEntity2.hostInfo;
                    if (liveHostInfo6 != null) {
                        twoFollowViewHolder.d.setImageURI(liveHostInfo6.avatar);
                    }
                    twoFollowViewHolder.e.setTextColor(fd0.f().a(this.d, this.e, "color_white3"));
                }
                LiveHostInfo liveHostInfo7 = liveFollowEntity2.hostInfo;
                if (liveHostInfo7 != null) {
                    if (!tc0.a(liveHostInfo7.name)) {
                        twoFollowViewHolder.b.setText(liveFollowEntity2.hostInfo.name);
                    }
                    twoFollowViewHolder.b.setTextColor(fd0.f().a(this.d, this.e, "color_1F1F1F"));
                }
                twoFollowViewHolder.itemView.setOnClickListener(new b(i));
                this.h = fd0.f().r();
                if (!tc0.a(twoFollowViewHolder.i) && !twoFollowViewHolder.i.equals(this.h)) {
                    twoFollowViewHolder.i = this.h;
                    if (twoFollowViewHolder.c.isAnimating()) {
                        twoFollowViewHolder.c.cancelAnimation();
                    }
                    p(twoFollowViewHolder.c, this.e);
                }
            }
        } else if (viewHolder instanceof ViewHolder) {
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            LiveFollowEntity liveFollowEntity3 = (LiveFollowEntity) qc0.b(this.b, i);
            if (liveFollowEntity3 != null) {
                if (liveFollowEntity3.needLogShow) {
                    d dVar3 = this.i;
                    if (dVar3 != null) {
                        dVar3.a(liveFollowEntity3, i);
                    }
                    liveFollowEntity3.needLogShow = false;
                }
                if (liveFollowEntity3.isMore) {
                    n(viewHolder2);
                    if (!LiveFeedPageSdk.IMMERSION.equals(this.e) && !LiveFeedPageSdk.VIDEO_BAR.equals(this.e)) {
                        if (!"night".equals(fd0.f().r()) && !"dark".equals(fd0.f().r())) {
                            viewHolder2.e.setImageResource(R.drawable.obfuscated_res_0x7f080f09);
                        } else {
                            viewHolder2.e.setImageResource(R.drawable.obfuscated_res_0x7f080f0b);
                        }
                    } else {
                        viewHolder2.e.setImageResource(R.drawable.obfuscated_res_0x7f080f0a);
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
                    viewHolder2.d.setTextColor(fd0.f().a(this.d, this.e, "color_white3"));
                }
                LiveHostInfo liveHostInfo9 = liveFollowEntity3.hostInfo;
                if (liveHostInfo9 != null) {
                    if (tc0.a(liveHostInfo9.name)) {
                        viewHolder2.a.setText(R.string.obfuscated_res_0x7f0f0ba1);
                    } else {
                        viewHolder2.a.setText(liveFollowEntity3.hostInfo.name);
                    }
                    viewHolder2.a.setTextColor(fd0.f().a(this.d, this.e, "color_1F1F1F"));
                }
                viewHolder2.itemView.setOnClickListener(new c(i));
                viewHolder2.c.getHierarchy().setPlaceholderImage(fd0.f().l(this.e), ScalingUtils.ScaleType.FIT_XY);
                if (LiveFeedPageSdk.IMMERSION.equals(this.e) || LiveFeedPageSdk.VIDEO_BAR.equals(this.e)) {
                    viewHolder2.c.getHierarchy().setUseGlobalColorFilter(false);
                }
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(fd0.f().a(this.d, this.e, "color_FF3333"));
                gradientDrawable.setCornerRadius(1000.0f);
                gradientDrawable.setStroke(oa0.b(this.d, 1.0f), fd0.f().a(this.d, this.e, "color_white1"));
                viewHolder2.d.setBackgroundDrawable(gradientDrawable);
                this.h = fd0.f().r();
                if (!tc0.a(viewHolder2.f) && !viewHolder2.f.equals(this.h)) {
                    viewHolder2.f = this.h;
                    if (viewHolder2.b.isAnimating()) {
                        viewHolder2.b.cancelAnimation();
                    }
                    p(viewHolder2.b, this.e);
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
            return new OneFollowViewHolder(this.a.inflate(R.layout.obfuscated_res_0x7f0d05cb, viewGroup, false), this.h, this.e);
        }
        if (getItemViewType(i) == 2 && this.g) {
            return new TwoFollowViewHolder(this.a.inflate(R.layout.obfuscated_res_0x7f0d05da, viewGroup, false), this.h, this.e);
        }
        return new ViewHolder(this.a.inflate(R.layout.obfuscated_res_0x7f0d05c3, viewGroup, false), this.h, this.e);
    }

    public final void u(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (o() == 1 && this.g) {
            OneFollowViewHolder oneFollowViewHolder = (OneFollowViewHolder) viewHolder;
            LiveBaseLottieView liveBaseLottieView = oneFollowViewHolder.d;
            if (liveBaseLottieView != null && liveBaseLottieView.getVisibility() == 0 && !oneFollowViewHolder.d.isAnimating()) {
                oneFollowViewHolder.d.playAnimation();
            }
        } else if (o() == 2 && this.g) {
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
}
