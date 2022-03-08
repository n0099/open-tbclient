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
import c.a.w.b.d.c.d;
import c.a.w.f.g.j;
import c.a.w.i.f;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LiveHostInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class LiveFeedPageConcernAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public LayoutInflater f33361b;

    /* renamed from: c  reason: collision with root package name */
    public List<d> f33362c;

    /* renamed from: d  reason: collision with root package name */
    public Context f33363d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33364e;

    /* renamed from: f  reason: collision with root package name */
    public String f33365f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f33366g;

    /* loaded from: classes4.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public LottieAnimationView f33367b;

        /* renamed from: c  reason: collision with root package name */
        public SimpleDraweeView f33368c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f33369d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f33370e;

        /* renamed from: f  reason: collision with root package name */
        public String f33371f;

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
            this.f33371f = "";
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f33372e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewHolder f33373f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ LiveFeedPageConcernAdapter f33374g;

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
            this.f33374g = liveFeedPageConcernAdapter;
            this.f33372e = i2;
            this.f33373f = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                LiveFeedPageSdk.m("FollowItemClick: position: " + this.f33372e);
                int i2 = this.f33372e;
                if (i2 < 0 || i2 >= this.f33374g.f33362c.size() || this.f33374g.f33362c.get(this.f33372e) == null) {
                    return;
                }
                LiveFeedPageSdk.m("FollowItemClick: scheme: " + ((d) this.f33374g.f33362c.get(this.f33372e)).f26298d);
                d dVar = (d) this.f33374g.f33362c.get(this.f33372e);
                String str = this.f33374g.f33364e ? "chenjinshi" : "zhibopindao";
                if (dVar.a) {
                    LiveFeedPageSdk.f().g().invokeScheme(this.f33373f.itemView.getContext(), dVar.f26298d);
                    c.a.w.b.c.a.j(this.f33374g.f33363d, this.f33374g.a, str);
                    return;
                }
                LiveFeedPageSdk.f().g().invokeScheme(this.f33373f.itemView.getContext(), dVar.f26298d);
                LiveHostInfo liveHostInfo = dVar.f26299e;
                c.a.w.b.c.a.h(this.f33374g.f33363d, this.f33374g.a, liveHostInfo == null ? "" : liveHostInfo.uk, str, this.f33372e + 1, dVar.f26297c, dVar.f26296b, dVar.f26300f);
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
        this.f33362c = new ArrayList();
        this.f33363d = context;
        this.a = str;
        this.f33364e = z;
        this.f33361b = LayoutInflater.from(context);
        this.f33365f = f.e().o();
        float a2 = c.a.w.b.f.a.a(this.f33363d, 8.0f);
        this.f33366g = new float[]{a2, a2, a2, a2, a2, a2, a2, a2};
    }

    public final void e(@NonNull ViewHolder viewHolder) {
        LottieAnimationView lottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) && (lottieAnimationView = viewHolder.f33367b) != null && lottieAnimationView.isAnimating()) {
            viewHolder.f33367b.cancelAnimation();
        }
    }

    public final void f(LottieAnimationView lottieAnimationView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lottieAnimationView) == null) || lottieAnimationView == null) {
            return;
        }
        if (this.f33364e) {
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
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewHolder) == null) || (lottieAnimationView = viewHolder.f33367b) == null || lottieAnimationView.getVisibility() != 0 || viewHolder.f33367b.isAnimating()) {
            return;
        }
        viewHolder.f33367b.playAnimation();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33362c.size() : invokeV.intValue;
    }

    public void setConcernList(List<d> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, list) == null) || c.a.w.f.g.d.c(list)) {
            return;
        }
        List<d> list2 = this.f33362c;
        if (list2 != null) {
            list2.clear();
        } else {
            this.f33362c = new ArrayList();
        }
        this.f33362c.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i2) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, viewHolder, i2) == null) || (dVar = (d) c.a.w.f.g.d.b(this.f33362c, i2)) == null) {
            return;
        }
        if (dVar.f26301g) {
            String str = this.f33364e ? "chenjinshi" : "zhibopindao";
            if (dVar.a) {
                c.a.w.b.c.a.k(this.f33363d, this.a, str);
            } else {
                LiveHostInfo liveHostInfo = dVar.f26299e;
                c.a.w.b.c.a.i(this.f33363d, this.a, liveHostInfo == null ? "" : liveHostInfo.uk, str, i2 + 1, dVar.f26297c, dVar.f26296b, dVar.f26300f);
            }
            dVar.f26301g = false;
        }
        if (dVar.a) {
            e(viewHolder);
            if (this.f33364e) {
                viewHolder.f33370e.setImageResource(R.drawable.live_feed_page_follow_jump_more_imm);
            } else if (!SkinManager.SKIN_TYPE_STR_NIGHT.equals(f.e().o()) && !SkinManager.SKIN_TYPE_STR_DARK.equals(f.e().o())) {
                viewHolder.f33370e.setImageResource(R.drawable.live_feed_page_follow_jump_more_day);
            } else {
                viewHolder.f33370e.setImageResource(R.drawable.live_feed_page_follow_jump_more_night);
            }
            viewHolder.f33370e.setVisibility(0);
            viewHolder.f33367b.setVisibility(8);
            viewHolder.f33369d.setVisibility(8);
            viewHolder.f33368c.setVisibility(8);
        } else {
            viewHolder.f33370e.setVisibility(8);
            viewHolder.f33367b.setVisibility(0);
            viewHolder.f33369d.setVisibility(0);
            viewHolder.f33368c.setVisibility(0);
            LiveHostInfo liveHostInfo2 = dVar.f26299e;
            if (liveHostInfo2 != null) {
                viewHolder.f33368c.setImageURI(liveHostInfo2.avatar);
            }
            viewHolder.f33369d.setTextColor(f.e().a(this.f33363d, this.f33364e, "color_white3"));
        }
        LiveHostInfo liveHostInfo3 = dVar.f26299e;
        if (liveHostInfo3 != null) {
            if (j.a(liveHostInfo3.name)) {
                viewHolder.a.setText(R.string.live_feed_page_follow_jump_more_txt);
            } else {
                viewHolder.a.setText(dVar.f26299e.name);
            }
            viewHolder.a.setTextColor(f.e().a(this.f33363d, this.f33364e, "color_1F1F1F"));
        }
        viewHolder.itemView.setOnClickListener(new a(this, i2, viewHolder));
        viewHolder.f33368c.getHierarchy().setPlaceholderImage(f.e().j(this.f33364e), ScalingUtils.ScaleType.FIT_XY);
        if (this.f33364e) {
            viewHolder.f33368c.getHierarchy().setUseGlobalColorFilter(false);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(f.e().a(this.f33363d, this.f33364e, "color_FF3333"));
        gradientDrawable.setCornerRadii(this.f33366g);
        gradientDrawable.setStroke(c.a.w.b.f.a.a(this.f33363d, 1.0f), f.e().a(this.f33363d, this.f33364e, "color_white1"));
        viewHolder.f33369d.setBackgroundDrawable(gradientDrawable);
        this.f33365f = f.e().o();
        if (j.a(viewHolder.f33371f) || viewHolder.f33371f.equals(this.f33365f)) {
            return;
        }
        viewHolder.f33371f = this.f33365f;
        if (viewHolder.f33367b.isAnimating()) {
            viewHolder.f33367b.cancelAnimation();
        }
        f(viewHolder.f33367b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, viewGroup, i2)) == null) {
            View inflate = this.f33361b.inflate(R.layout.live_feed_page_follow_list_layout, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder(inflate);
            viewHolder.a = (TextView) inflate.findViewById(R.id.tv_item_name);
            viewHolder.f33369d = (TextView) inflate.findViewById(R.id.avatar_tip);
            viewHolder.f33370e = (ImageView) inflate.findViewById(R.id.follow_jump_more);
            viewHolder.f33367b = (LottieAnimationView) inflate.findViewById(R.id.avatar_lottie);
            viewHolder.f33368c = (SimpleDraweeView) inflate.findViewById(R.id.avatar_iv);
            viewHolder.f33371f = this.f33365f;
            f(viewHolder.f33367b);
            viewHolder.f33367b.loop(true);
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
