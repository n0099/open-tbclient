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
import c.a.x.b.d.c.d;
import c.a.x.c.a.b;
import c.a.x.c.a.c;
import c.a.x.c.a.e;
import c.a.x.g.g.j;
import c.a.x.k.f;
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
/* loaded from: classes10.dex */
public class LiveFeedPageConcernAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public LayoutInflater f35735b;

    /* renamed from: c  reason: collision with root package name */
    public List<d> f35736c;

    /* renamed from: d  reason: collision with root package name */
    public Context f35737d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f35738e;

    /* renamed from: f  reason: collision with root package name */
    public String f35739f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f35740g;

    /* loaded from: classes10.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public LottieAnimationView f35741b;

        /* renamed from: c  reason: collision with root package name */
        public SimpleDraweeView f35742c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f35743d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f35744e;

        /* renamed from: f  reason: collision with root package name */
        public String f35745f;

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
            this.f35745f = "";
        }
    }

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f35746e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewHolder f35747f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ LiveFeedPageConcernAdapter f35748g;

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
            this.f35748g = liveFeedPageConcernAdapter;
            this.f35746e = i2;
            this.f35747f = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                LiveFeedPageSdk.m("FollowItemClick: position: " + this.f35746e);
                int i2 = this.f35746e;
                if (i2 < 0 || i2 >= this.f35748g.f35736c.size() || this.f35748g.f35736c.get(this.f35746e) == null) {
                    return;
                }
                LiveFeedPageSdk.m("FollowItemClick: scheme: " + ((d) this.f35748g.f35736c.get(this.f35746e)).f26972d);
                d dVar = (d) this.f35748g.f35736c.get(this.f35746e);
                String str = this.f35748g.f35738e ? "chenjinshi" : "zhibopindao";
                if (dVar.a) {
                    LiveFeedPageSdk.f().g().invokeScheme(this.f35747f.itemView.getContext(), dVar.f26972d);
                    c.a.x.b.c.a.j(this.f35748g.f35737d, this.f35748g.a, str);
                    return;
                }
                LiveFeedPageSdk.f().g().invokeScheme(this.f35747f.itemView.getContext(), dVar.f26972d);
                LiveHostInfo liveHostInfo = dVar.f26973e;
                c.a.x.b.c.a.h(this.f35748g.f35737d, this.f35748g.a, liveHostInfo == null ? "" : liveHostInfo.uk, str, this.f35746e + 1, dVar.f26971c, dVar.f26970b, dVar.f26974f);
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
        this.f35736c = new ArrayList();
        this.f35737d = context;
        this.a = str;
        this.f35738e = z;
        this.f35735b = LayoutInflater.from(context);
        this.f35739f = f.e().o();
        float a2 = c.a.x.b.f.a.a(this.f35737d, 8.0f);
        this.f35740g = new float[]{a2, a2, a2, a2, a2, a2, a2, a2};
    }

    public final void e(@NonNull ViewHolder viewHolder) {
        LottieAnimationView lottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) && (lottieAnimationView = viewHolder.f35741b) != null && lottieAnimationView.isAnimating()) {
            viewHolder.f35741b.cancelAnimation();
        }
    }

    public final void f(LottieAnimationView lottieAnimationView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lottieAnimationView) == null) || lottieAnimationView == null) {
            return;
        }
        if (this.f35738e) {
            lottieAnimationView.setAnimation("live_feed_page_shinning.json");
        } else if (!SkinManager.SKIN_TYPE_STR_NIGHT.equals(f.e().o()) && !SkinManager.SKIN_TYPE_STR_DARK.equals(f.e().o())) {
            lottieAnimationView.setAnimation("live_feed_page_shinning.json");
        } else {
            lottieAnimationView.setAnimation("live_feed_page_shinning_night.json");
        }
    }

    public final void g(@NonNull ViewHolder viewHolder) {
        LottieAnimationView lottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewHolder) == null) || (lottieAnimationView = viewHolder.f35741b) == null || lottieAnimationView.getVisibility() != 0 || viewHolder.f35741b.isAnimating()) {
            return;
        }
        viewHolder.f35741b.playAnimation();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f35736c.size() : invokeV.intValue;
    }

    public void setConcernList(List<d> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, list) == null) || c.a.x.g.g.d.c(list)) {
            return;
        }
        List<d> list2 = this.f35736c;
        if (list2 != null) {
            list2.clear();
        } else {
            this.f35736c = new ArrayList();
        }
        this.f35736c.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i2) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, viewHolder, i2) == null) || (dVar = (d) c.a.x.g.g.d.b(this.f35736c, i2)) == null) {
            return;
        }
        if (dVar.f26975g) {
            String str = this.f35738e ? "chenjinshi" : "zhibopindao";
            if (dVar.a) {
                c.a.x.b.c.a.k(this.f35737d, this.a, str);
            } else {
                LiveHostInfo liveHostInfo = dVar.f26973e;
                c.a.x.b.c.a.i(this.f35737d, this.a, liveHostInfo == null ? "" : liveHostInfo.uk, str, i2 + 1, dVar.f26971c, dVar.f26970b, dVar.f26974f);
            }
            dVar.f26975g = false;
        }
        if (dVar.a) {
            e(viewHolder);
            if (this.f35738e) {
                viewHolder.f35744e.setImageResource(b.live_feed_page_follow_jump_more_imm);
            } else if (!SkinManager.SKIN_TYPE_STR_NIGHT.equals(f.e().o()) && !SkinManager.SKIN_TYPE_STR_DARK.equals(f.e().o())) {
                viewHolder.f35744e.setImageResource(b.live_feed_page_follow_jump_more_day);
            } else {
                viewHolder.f35744e.setImageResource(b.live_feed_page_follow_jump_more_night);
            }
            viewHolder.f35744e.setVisibility(0);
            viewHolder.f35741b.setVisibility(8);
            viewHolder.f35743d.setVisibility(8);
            viewHolder.f35742c.setVisibility(8);
        } else {
            viewHolder.f35744e.setVisibility(8);
            viewHolder.f35741b.setVisibility(0);
            viewHolder.f35743d.setVisibility(0);
            viewHolder.f35742c.setVisibility(0);
            LiveHostInfo liveHostInfo2 = dVar.f26973e;
            if (liveHostInfo2 != null) {
                viewHolder.f35742c.setImageURI(liveHostInfo2.avatar);
            }
            viewHolder.f35743d.setTextColor(f.e().a(this.f35737d, this.f35738e, "color_white3"));
        }
        LiveHostInfo liveHostInfo3 = dVar.f26973e;
        if (liveHostInfo3 != null) {
            if (j.a(liveHostInfo3.name)) {
                viewHolder.a.setText(e.live_feed_page_follow_jump_more_txt);
            } else {
                viewHolder.a.setText(dVar.f26973e.name);
            }
            viewHolder.a.setTextColor(f.e().a(this.f35737d, this.f35738e, "color_1F1F1F"));
        }
        viewHolder.itemView.setOnClickListener(new a(this, i2, viewHolder));
        viewHolder.f35742c.getHierarchy().setPlaceholderImage(f.e().j(this.f35738e), ScalingUtils.ScaleType.FIT_XY);
        if (this.f35738e) {
            viewHolder.f35742c.getHierarchy().setUseGlobalColorFilter(false);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(f.e().a(this.f35737d, this.f35738e, "color_FF3333"));
        gradientDrawable.setCornerRadii(this.f35740g);
        gradientDrawable.setStroke(c.a.x.b.f.a.a(this.f35737d, 1.0f), f.e().a(this.f35737d, this.f35738e, "color_white1"));
        viewHolder.f35743d.setBackgroundDrawable(gradientDrawable);
        this.f35739f = f.e().o();
        if (j.a(viewHolder.f35745f) || viewHolder.f35745f.equals(this.f35739f)) {
            return;
        }
        viewHolder.f35745f = this.f35739f;
        if (viewHolder.f35741b.isAnimating()) {
            viewHolder.f35741b.cancelAnimation();
        }
        f(viewHolder.f35741b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, viewGroup, i2)) == null) {
            View inflate = this.f35735b.inflate(c.a.x.c.a.d.live_feed_page_follow_list_layout, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder(inflate);
            viewHolder.a = (TextView) inflate.findViewById(c.tv_item_name);
            viewHolder.f35743d = (TextView) inflate.findViewById(c.avatar_tip);
            viewHolder.f35744e = (ImageView) inflate.findViewById(c.follow_jump_more);
            viewHolder.f35741b = (LottieAnimationView) inflate.findViewById(c.avatar_lottie);
            viewHolder.f35742c = (SimpleDraweeView) inflate.findViewById(c.avatar_iv);
            viewHolder.f35745f = this.f35739f;
            f(viewHolder.f35741b);
            viewHolder.f35741b.loop(true);
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
