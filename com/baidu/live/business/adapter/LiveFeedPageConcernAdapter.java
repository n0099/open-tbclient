package com.baidu.live.business.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import b.a.w.b.d.c.d;
import b.a.w.c.a.b;
import b.a.w.c.a.c;
import b.a.w.c.a.e;
import b.a.w.e.g.j;
import b.a.w.i.f;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LiveHostInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class LiveFeedPageConcernAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f38701a;

    /* renamed from: b  reason: collision with root package name */
    public LayoutInflater f38702b;

    /* renamed from: c  reason: collision with root package name */
    public List<d> f38703c;

    /* renamed from: d  reason: collision with root package name */
    public Context f38704d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f38705e;

    /* renamed from: f  reason: collision with root package name */
    public String f38706f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f38707g;

    /* loaded from: classes7.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f38708a;

        /* renamed from: b  reason: collision with root package name */
        public LottieAnimationView f38709b;

        /* renamed from: c  reason: collision with root package name */
        public SimpleDraweeView f38710c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f38711d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f38712e;

        /* renamed from: f  reason: collision with root package name */
        public String f38713f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38713f = "";
        }
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f38714e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewHolder f38715f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ LiveFeedPageConcernAdapter f38716g;

        public a(LiveFeedPageConcernAdapter liveFeedPageConcernAdapter, int i2, ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedPageConcernAdapter, Integer.valueOf(i2), viewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38716g = liveFeedPageConcernAdapter;
            this.f38714e = i2;
            this.f38715f = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                LiveFeedPageSdk.l("FollowItemClick: position: " + this.f38714e);
                int i2 = this.f38714e;
                if (i2 < 0 || i2 >= this.f38716g.f38703c.size() || this.f38716g.f38703c.get(this.f38714e) == null) {
                    return;
                }
                LiveFeedPageSdk.l("FollowItemClick: scheme: " + ((d) this.f38716g.f38703c.get(this.f38714e)).f29211d);
                d dVar = (d) this.f38716g.f38703c.get(this.f38714e);
                String str = this.f38716g.f38705e ? "chenjinshi" : "zhibopindao";
                if (dVar.f29208a) {
                    LiveFeedPageSdk.e().f().invokeScheme(this.f38715f.itemView.getContext(), dVar.f29211d);
                    b.a.w.b.c.a.j(this.f38716g.f38704d, this.f38716g.f38701a, str);
                    return;
                }
                LiveFeedPageSdk.e().f().invokeScheme(this.f38715f.itemView.getContext(), dVar.f29211d);
                LiveHostInfo liveHostInfo = dVar.f29212e;
                b.a.w.b.c.a.h(this.f38716g.f38704d, this.f38716g.f38701a, liveHostInfo == null ? "" : liveHostInfo.uk, str, this.f38714e + 1, dVar.f29210c, dVar.f29209b, dVar.f29213f);
            }
        }
    }

    public LiveFeedPageConcernAdapter(Context context, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38703c = new ArrayList();
        this.f38704d = context;
        this.f38701a = str;
        this.f38705e = z;
        this.f38702b = LayoutInflater.from(context);
        this.f38706f = f.e().n();
        float a2 = b.a.w.b.f.a.a(this.f38704d, 8.0f);
        this.f38707g = new float[]{a2, a2, a2, a2, a2, a2, a2, a2};
    }

    public final void e(@NonNull ViewHolder viewHolder) {
        LottieAnimationView lottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) && (lottieAnimationView = viewHolder.f38709b) != null && lottieAnimationView.isAnimating()) {
            viewHolder.f38709b.cancelAnimation();
        }
    }

    public final void f(LottieAnimationView lottieAnimationView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lottieAnimationView) == null) || lottieAnimationView == null) {
            return;
        }
        if (this.f38705e) {
            lottieAnimationView.setAnimation("live_feed_page_shinning.json");
        } else if (!"night".equals(f.e().n()) && !SkinManager.SKIN_TYPE_STR_DARK.equals(f.e().n())) {
            lottieAnimationView.setAnimation("live_feed_page_shinning.json");
        } else {
            lottieAnimationView.setAnimation("live_feed_page_shinning_night.json");
        }
    }

    public final void g(@NonNull ViewHolder viewHolder) {
        LottieAnimationView lottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewHolder) == null) || (lottieAnimationView = viewHolder.f38709b) == null || lottieAnimationView.getVisibility() != 0 || viewHolder.f38709b.isAnimating()) {
            return;
        }
        viewHolder.f38709b.playAnimation();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f38703c.size() : invokeV.intValue;
    }

    public void setConcernList(List<d> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, list) == null) || b.a.w.e.g.d.c(list)) {
            return;
        }
        List<d> list2 = this.f38703c;
        if (list2 != null) {
            list2.clear();
        } else {
            this.f38703c = new ArrayList();
        }
        this.f38703c.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i2) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, viewHolder, i2) == null) || (dVar = (d) b.a.w.e.g.d.b(this.f38703c, i2)) == null) {
            return;
        }
        if (dVar.f29214g) {
            String str = this.f38705e ? "chenjinshi" : "zhibopindao";
            if (dVar.f29208a) {
                b.a.w.b.c.a.k(this.f38704d, this.f38701a, str);
            } else {
                LiveHostInfo liveHostInfo = dVar.f29212e;
                b.a.w.b.c.a.i(this.f38704d, this.f38701a, liveHostInfo == null ? "" : liveHostInfo.uk, str, i2 + 1, dVar.f29210c, dVar.f29209b, dVar.f29213f);
            }
            dVar.f29214g = false;
        }
        if (dVar.f29208a) {
            e(viewHolder);
            if (this.f38705e) {
                viewHolder.f38712e.setImageResource(b.live_feed_page_follow_jump_more_imm);
            } else if (!"night".equals(f.e().n()) && !SkinManager.SKIN_TYPE_STR_DARK.equals(f.e().n())) {
                viewHolder.f38712e.setImageResource(b.live_feed_page_follow_jump_more_day);
            } else {
                viewHolder.f38712e.setImageResource(b.live_feed_page_follow_jump_more_night);
            }
            viewHolder.f38712e.setVisibility(0);
            viewHolder.f38709b.setVisibility(8);
            viewHolder.f38711d.setVisibility(8);
            viewHolder.f38710c.setVisibility(8);
        } else {
            viewHolder.f38712e.setVisibility(8);
            viewHolder.f38709b.setVisibility(0);
            viewHolder.f38711d.setVisibility(0);
            viewHolder.f38710c.setVisibility(0);
            LiveHostInfo liveHostInfo2 = dVar.f29212e;
            if (liveHostInfo2 != null) {
                viewHolder.f38710c.setImageURI(liveHostInfo2.avatar);
            }
            viewHolder.f38711d.setTextColor(f.e().a(this.f38704d, this.f38705e, "color_white3"));
        }
        LiveHostInfo liveHostInfo3 = dVar.f29212e;
        if (liveHostInfo3 != null) {
            if (j.a(liveHostInfo3.name)) {
                viewHolder.f38708a.setText(e.live_feed_page_follow_jump_more_txt);
            } else {
                viewHolder.f38708a.setText(dVar.f29212e.name);
            }
            viewHolder.f38708a.setTextColor(f.e().a(this.f38704d, this.f38705e, "color_1F1F1F"));
        }
        viewHolder.itemView.setOnClickListener(new a(this, i2, viewHolder));
        viewHolder.f38710c.getHierarchy().setPlaceholderImage(f.e().j(this.f38705e), ScalingUtils.ScaleType.FIT_XY);
        if (this.f38705e) {
            viewHolder.f38710c.getHierarchy().setUseGlobalColorFilter(false);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(f.e().a(this.f38704d, this.f38705e, "color_FF3333"));
        gradientDrawable.setCornerRadii(this.f38707g);
        gradientDrawable.setStroke(b.a.w.b.f.a.a(this.f38704d, 1.0f), f.e().a(this.f38704d, this.f38705e, "color_white1"));
        viewHolder.f38711d.setBackgroundDrawable(gradientDrawable);
        this.f38706f = f.e().n();
        if (j.a(viewHolder.f38713f) || viewHolder.f38713f.equals(this.f38706f)) {
            return;
        }
        viewHolder.f38713f = this.f38706f;
        if (viewHolder.f38709b.isAnimating()) {
            viewHolder.f38709b.cancelAnimation();
        }
        f(viewHolder.f38709b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, viewGroup, i2)) == null) {
            View inflate = this.f38702b.inflate(b.a.w.c.a.d.live_feed_page_follow_list_layout, (ViewGroup) null);
            ViewHolder viewHolder = new ViewHolder(inflate);
            viewHolder.f38708a = (TextView) inflate.findViewById(c.tv_item_name);
            viewHolder.f38711d = (TextView) inflate.findViewById(c.avatar_tip);
            viewHolder.f38712e = (ImageView) inflate.findViewById(c.follow_jump_more);
            viewHolder.f38709b = (LottieAnimationView) inflate.findViewById(c.avatar_lottie);
            viewHolder.f38710c = (SimpleDraweeView) inflate.findViewById(c.avatar_iv);
            viewHolder.f38713f = this.f38706f;
            f(viewHolder.f38709b);
            viewHolder.f38709b.loop(true);
            return viewHolder;
        }
        return (ViewHolder) invokeLI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, viewHolder) == null) {
            super.onViewAttachedToWindow((LiveFeedPageConcernAdapter) viewHolder);
            g(viewHolder);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, viewHolder) == null) {
            super.onViewDetachedFromWindow((LiveFeedPageConcernAdapter) viewHolder);
            e(viewHolder);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, viewHolder) == null) {
            super.onViewRecycled((LiveFeedPageConcernAdapter) viewHolder);
            e(viewHolder);
        }
    }
}
