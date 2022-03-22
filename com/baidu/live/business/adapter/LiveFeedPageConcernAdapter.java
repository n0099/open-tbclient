package com.baidu.live.business.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.v.b.d.c.d;
import c.a.v.f.g.j;
import c.a.v.i.f;
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
/* loaded from: classes3.dex */
public class LiveFeedPageConcernAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public LayoutInflater f25698b;

    /* renamed from: c  reason: collision with root package name */
    public List<d> f25699c;

    /* renamed from: d  reason: collision with root package name */
    public Context f25700d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f25701e;

    /* renamed from: f  reason: collision with root package name */
    public String f25702f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f25703g;

    /* loaded from: classes3.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public LottieAnimationView f25704b;

        /* renamed from: c  reason: collision with root package name */
        public SimpleDraweeView f25705c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f25706d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f25707e;

        /* renamed from: f  reason: collision with root package name */
        public String f25708f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25708f = "";
        }
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewHolder f25709b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LiveFeedPageConcernAdapter f25710c;

        public a(LiveFeedPageConcernAdapter liveFeedPageConcernAdapter, int i, ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedPageConcernAdapter, Integer.valueOf(i), viewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25710c = liveFeedPageConcernAdapter;
            this.a = i;
            this.f25709b = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                LiveFeedPageSdk.m("FollowItemClick: position: " + this.a);
                int i = this.a;
                if (i < 0 || i >= this.f25710c.f25699c.size() || this.f25710c.f25699c.get(this.a) == null) {
                    return;
                }
                LiveFeedPageSdk.m("FollowItemClick: scheme: " + ((d) this.f25710c.f25699c.get(this.a)).f21435d);
                d dVar = (d) this.f25710c.f25699c.get(this.a);
                String str = this.f25710c.f25701e ? "chenjinshi" : "zhibopindao";
                if (dVar.a) {
                    LiveFeedPageSdk.f().g().invokeScheme(this.f25709b.itemView.getContext(), dVar.f21435d);
                    c.a.v.b.c.a.j(this.f25710c.f25700d, this.f25710c.a, str);
                    return;
                }
                LiveFeedPageSdk.f().g().invokeScheme(this.f25709b.itemView.getContext(), dVar.f21435d);
                LiveHostInfo liveHostInfo = dVar.f21436e;
                c.a.v.b.c.a.h(this.f25710c.f25700d, this.f25710c.a, liveHostInfo == null ? "" : liveHostInfo.uk, str, this.a + 1, dVar.f21434c, dVar.f21433b, dVar.f21437f);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25699c = new ArrayList();
        this.f25700d = context;
        this.a = str;
        this.f25701e = z;
        this.f25698b = LayoutInflater.from(context);
        this.f25702f = f.e().o();
        float a2 = c.a.v.b.f.a.a(this.f25700d, 8.0f);
        this.f25703g = new float[]{a2, a2, a2, a2, a2, a2, a2, a2};
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f25699c.size() : invokeV.intValue;
    }

    public final void h(@NonNull ViewHolder viewHolder) {
        LottieAnimationView lottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewHolder) == null) && (lottieAnimationView = viewHolder.f25704b) != null && lottieAnimationView.isAnimating()) {
            viewHolder.f25704b.cancelAnimation();
        }
    }

    public final void i(LottieAnimationView lottieAnimationView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lottieAnimationView) == null) || lottieAnimationView == null) {
            return;
        }
        if (this.f25701e) {
            lottieAnimationView.setAnimation("live_feed_page_shinning.json");
        } else if (!SkinManager.SKIN_TYPE_STR_NIGHT.equals(f.e().o()) && !SkinManager.SKIN_TYPE_STR_DARK.equals(f.e().o())) {
            lottieAnimationView.setAnimation("live_feed_page_shinning.json");
        } else {
            lottieAnimationView.setAnimation("live_feed_page_shinning_night.json");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, viewHolder, i) == null) || (dVar = (d) c.a.v.f.g.d.b(this.f25699c, i)) == null) {
            return;
        }
        if (dVar.f21438g) {
            String str = this.f25701e ? "chenjinshi" : "zhibopindao";
            if (dVar.a) {
                c.a.v.b.c.a.k(this.f25700d, this.a, str);
            } else {
                LiveHostInfo liveHostInfo = dVar.f21436e;
                c.a.v.b.c.a.i(this.f25700d, this.a, liveHostInfo == null ? "" : liveHostInfo.uk, str, i + 1, dVar.f21434c, dVar.f21433b, dVar.f21437f);
            }
            dVar.f21438g = false;
        }
        if (dVar.a) {
            h(viewHolder);
            if (this.f25701e) {
                viewHolder.f25707e.setImageResource(R.drawable.obfuscated_res_0x7f080d0e);
            } else if (!SkinManager.SKIN_TYPE_STR_NIGHT.equals(f.e().o()) && !SkinManager.SKIN_TYPE_STR_DARK.equals(f.e().o())) {
                viewHolder.f25707e.setImageResource(R.drawable.obfuscated_res_0x7f080d0d);
            } else {
                viewHolder.f25707e.setImageResource(R.drawable.obfuscated_res_0x7f080d0f);
            }
            viewHolder.f25707e.setVisibility(0);
            viewHolder.f25704b.setVisibility(8);
            viewHolder.f25706d.setVisibility(8);
            viewHolder.f25705c.setVisibility(8);
        } else {
            viewHolder.f25707e.setVisibility(8);
            viewHolder.f25704b.setVisibility(0);
            viewHolder.f25706d.setVisibility(0);
            viewHolder.f25705c.setVisibility(0);
            LiveHostInfo liveHostInfo2 = dVar.f21436e;
            if (liveHostInfo2 != null) {
                viewHolder.f25705c.setImageURI(liveHostInfo2.avatar);
            }
            viewHolder.f25706d.setTextColor(f.e().a(this.f25700d, this.f25701e, "color_white3"));
        }
        LiveHostInfo liveHostInfo3 = dVar.f21436e;
        if (liveHostInfo3 != null) {
            if (j.a(liveHostInfo3.name)) {
                viewHolder.a.setText(R.string.obfuscated_res_0x7f0f09fa);
            } else {
                viewHolder.a.setText(dVar.f21436e.name);
            }
            viewHolder.a.setTextColor(f.e().a(this.f25700d, this.f25701e, "color_1F1F1F"));
        }
        viewHolder.itemView.setOnClickListener(new a(this, i, viewHolder));
        viewHolder.f25705c.getHierarchy().setPlaceholderImage(f.e().j(this.f25701e), ScalingUtils.ScaleType.FIT_XY);
        if (this.f25701e) {
            viewHolder.f25705c.getHierarchy().setUseGlobalColorFilter(false);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(f.e().a(this.f25700d, this.f25701e, "color_FF3333"));
        gradientDrawable.setCornerRadii(this.f25703g);
        gradientDrawable.setStroke(c.a.v.b.f.a.a(this.f25700d, 1.0f), f.e().a(this.f25700d, this.f25701e, "color_white1"));
        viewHolder.f25706d.setBackgroundDrawable(gradientDrawable);
        this.f25702f = f.e().o();
        if (j.a(viewHolder.f25708f) || viewHolder.f25708f.equals(this.f25702f)) {
            return;
        }
        viewHolder.f25708f = this.f25702f;
        if (viewHolder.f25704b.isAnimating()) {
            viewHolder.f25704b.cancelAnimation();
        }
        i(viewHolder.f25704b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i)) == null) {
            View inflate = this.f25698b.inflate(R.layout.obfuscated_res_0x7f0d0514, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder(inflate);
            viewHolder.a = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0921c8);
            viewHolder.f25706d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0902ee);
            viewHolder.f25707e = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0909fc);
            viewHolder.f25704b = (LottieAnimationView) inflate.findViewById(R.id.obfuscated_res_0x7f0902e9);
            viewHolder.f25705c = (SimpleDraweeView) inflate.findViewById(R.id.obfuscated_res_0x7f0902e8);
            viewHolder.f25708f = this.f25702f;
            i(viewHolder.f25704b);
            viewHolder.f25704b.loop(true);
            return viewHolder;
        }
        return (ViewHolder) invokeLI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l */
    public void onViewAttachedToWindow(@NonNull ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, viewHolder) == null) {
            super.onViewAttachedToWindow(viewHolder);
            p(viewHolder);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m */
    public void onViewDetachedFromWindow(@NonNull ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, viewHolder) == null) {
            super.onViewDetachedFromWindow(viewHolder);
            h(viewHolder);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public void onViewRecycled(@NonNull ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, viewHolder) == null) {
            super.onViewRecycled(viewHolder);
            h(viewHolder);
        }
    }

    public void o(List<d> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) || c.a.v.f.g.d.c(list)) {
            return;
        }
        List<d> list2 = this.f25699c;
        if (list2 != null) {
            list2.clear();
        } else {
            this.f25699c = new ArrayList();
        }
        this.f25699c.addAll(list);
        notifyDataSetChanged();
    }

    public final void p(@NonNull ViewHolder viewHolder) {
        LottieAnimationView lottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, viewHolder) == null) || (lottieAnimationView = viewHolder.f25704b) == null || lottieAnimationView.getVisibility() != 0 || viewHolder.f25704b.isAnimating()) {
            return;
        }
        viewHolder.f25704b.playAnimation();
    }
}
