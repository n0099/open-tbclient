package com.baidu.live.business.view.tool;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LiveFeedConfig;
import com.baidu.live.business.model.data.LiveFeedToolInfo;
import com.baidu.live.business.model.data.LiveFeedToolWrapData;
import com.baidu.live.business.view.search.LiveSearchGuideView;
import com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ab0;
import com.repackage.m80;
import com.repackage.wa0;
import java.util.List;
/* loaded from: classes2.dex */
public class LiveFeedPageToolFloatLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;
    public boolean b;
    public ObjectAnimator c;
    public View d;
    public ImageView e;
    public ViewGroup f;
    public LiveSearchGuideView g;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveFeedToolInfo a;
        public final /* synthetic */ LiveFeedPageToolFloatLayout b;

        public a(LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout, LiveFeedToolInfo liveFeedToolInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedPageToolFloatLayout, liveFeedToolInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = liveFeedPageToolFloatLayout;
            this.a = liveFeedToolInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.a == null) {
                return;
            }
            d dVar = this.b.a;
            LiveFeedToolInfo liveFeedToolInfo = this.a;
            dVar.a(liveFeedToolInfo.name, liveFeedToolInfo.cmd);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveFeedPageToolFloatLayout a;

        public b(LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedPageToolFloatLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveFeedPageToolFloatLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null) {
                return;
            }
            this.a.a.b();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveFeedPageToolFloatLayout a;

        public c(LiveFeedPageToolFloatLayout liveFeedPageToolFloatLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveFeedPageToolFloatLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveFeedPageToolFloatLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null) {
                return;
            }
            this.a.a.b();
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(String str, String str2);

        void b();

        void onItemShow(String str);

        void onSearchShowing(boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveFeedPageToolFloatLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c();
    }

    public void b(boolean z) {
        int alpha;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            ObjectAnimator objectAnimator = this.c;
            if (objectAnimator != null) {
                objectAnimator.end();
            }
            if (z) {
                this.c = ObjectAnimator.ofFloat(this, Key.ALPHA, getAlpha(), 0.0f);
                alpha = (int) (getAlpha() * 200.0f);
            } else {
                this.c = ObjectAnimator.ofFloat(this, Key.ALPHA, getAlpha(), 1.0f);
                alpha = (int) ((1.0f - getAlpha()) * 200.0f);
            }
            this.c.setDuration(alpha);
            this.c.setInterpolator(new LinearInterpolator());
            this.c.start();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0539, (ViewGroup) this, true);
            this.d = findViewById(R.id.obfuscated_res_0x7f09134f);
            this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f091344);
            this.f = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091350);
            this.g = (LiveSearchGuideView) findViewById(R.id.obfuscated_res_0x7f091345);
            this.e.setOnClickListener(new c(this));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(TypedValue.applyDimension(1, 7.0f, getResources().getDisplayMetrics()));
            this.f.setBackgroundDrawable(gradientDrawable);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(String str) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            LiveSearchGuideView liveSearchGuideView = this.g;
            if (liveSearchGuideView != null) {
                liveSearchGuideView.b(str, this.b);
            }
            ImageView imageView = this.e;
            if (imageView != null) {
                imageView.setImageResource(ab0.f().p(this.b ? LiveFeedPageSdk.IMMERSION : LiveFeedPageSdk.HOST_LIVE_TAB));
            }
            ViewGroup viewGroup = this.f;
            if (viewGroup != null) {
                Drawable background = viewGroup.getBackground();
                if (background instanceof GradientDrawable) {
                    if (this.b) {
                        ((GradientDrawable) background).setColor(-10263190);
                    } else {
                        int hashCode = str.hashCode();
                        if (hashCode != 99228) {
                            if (hashCode == 104817688 && str.equals("night")) {
                                c2 = 1;
                                if (c2 != 0) {
                                    ((GradientDrawable) background).setColor(-1);
                                } else if (c2 == 1) {
                                    ((GradientDrawable) background).setColor(BDEmotionBagVerticalLayout.NIGHT_COLOR_EMOTION_BAG);
                                }
                            }
                            c2 = 65535;
                            if (c2 != 0) {
                            }
                        } else {
                            if (str.equals("day")) {
                                c2 = 0;
                                if (c2 != 0) {
                                }
                            }
                            c2 = 65535;
                            if (c2 != 0) {
                            }
                        }
                    }
                    this.f.setBackgroundDrawable(background);
                }
                for (int i = 0; i < this.f.getChildCount(); i++) {
                    if (this.f.getChildAt(i) instanceof LiveFeedPageToolItemView) {
                        ((LiveFeedPageToolItemView) this.f.getChildAt(i)).b(str, this.b);
                    }
                }
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            float b2 = m80.b(getContext(), this.b ? 38.0f : 47.0f);
            wa0.f(this.e, b2, b2);
            this.g.c();
            if (this.f != null) {
                for (int i = 0; i < this.f.getChildCount(); i++) {
                    if (this.f.getChildAt(i) instanceof LiveFeedPageToolItemView) {
                        ((LiveFeedPageToolItemView) this.f.getChildAt(i)).c();
                    }
                }
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a = null;
            ViewGroup viewGroup = this.f;
            if (viewGroup != null && viewGroup.getChildCount() > 0) {
                for (int i = 0; i < this.f.getChildCount(); i++) {
                    if (this.f.getChildAt(i) instanceof LiveFeedPageToolItemView) {
                        ((LiveFeedPageToolItemView) this.f.getChildAt(i)).d();
                    }
                }
            }
            ObjectAnimator objectAnimator = this.c;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
        }
    }

    public void setCallback(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            this.a = dVar;
        }
    }

    public void setData(LiveFeedToolWrapData liveFeedToolWrapData, LiveFeedConfig liveFeedConfig) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, liveFeedToolWrapData, liveFeedConfig) == null) {
            boolean z = liveFeedConfig != null ? liveFeedConfig.searchIsOpen : false;
            ImageView imageView2 = this.e;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            List<LiveFeedToolInfo> list = liveFeedToolWrapData != null ? liveFeedToolWrapData.infos : null;
            if (list != null && !list.isEmpty()) {
                ViewGroup viewGroup = this.f;
                if (viewGroup == null) {
                    return;
                }
                viewGroup.removeAllViews();
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    LiveFeedToolInfo liveFeedToolInfo = list.get(i);
                    LiveFeedPageToolItemView liveFeedPageToolItemView = new LiveFeedPageToolItemView(this.f.getContext());
                    liveFeedPageToolItemView.setData(this.b, liveFeedToolInfo.icon, liveFeedToolInfo.name);
                    liveFeedPageToolItemView.setOnClickListener(new a(this, liveFeedToolInfo));
                    this.f.addView(liveFeedPageToolItemView, new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 57.0f, getResources().getDisplayMetrics())));
                    d dVar = this.a;
                    if (dVar != null) {
                        dVar.onItemShow(liveFeedToolInfo.name);
                    }
                }
                if (z) {
                    LiveFeedPageToolItemView liveFeedPageToolItemView2 = new LiveFeedPageToolItemView(this.f.getContext());
                    liveFeedPageToolItemView2.setData(this.b, R.drawable.obfuscated_res_0x7f080ce2, "搜索");
                    liveFeedPageToolItemView2.setOnClickListener(new b(this));
                    this.f.addView(liveFeedPageToolItemView2, new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 57.0f, getResources().getDisplayMetrics())));
                }
                int childCount = this.f.getChildCount();
                int i2 = 0;
                while (i2 < childCount) {
                    if (this.f.getChildAt(i2) instanceof LiveFeedPageToolItemView) {
                        ((LiveFeedPageToolItemView) this.f.getChildAt(i2)).setDividerShowing(i2 != childCount + (-1));
                    }
                    i2++;
                }
            } else if (z && (imageView = this.e) != null) {
                imageView.setVisibility(0);
            }
            d dVar2 = this.a;
            if (dVar2 != null) {
                dVar2.onSearchShowing(z);
            }
        }
    }

    public void setImmersion(boolean z) {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.b = z;
            View view2 = this.d;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).rightMargin = m80.b(getContext(), z ? 15.0f : 10.0f);
                    this.d.setLayoutParams(layoutParams2);
                }
            }
            ViewGroup viewGroup = this.f;
            if (viewGroup != null) {
                ViewGroup.LayoutParams layoutParams3 = viewGroup.getLayoutParams();
                if (layoutParams3 instanceof FrameLayout.LayoutParams) {
                    ((FrameLayout.LayoutParams) layoutParams3).rightMargin = m80.b(getContext(), z ? 0.0f : 4.0f);
                    this.f.setLayoutParams(layoutParams3);
                }
            }
            ImageView imageView = this.e;
            if (imageView != null && (layoutParams = imageView.getLayoutParams()) != null) {
                int b2 = m80.b(getContext(), z ? 38.0f : 47.0f);
                layoutParams.width = b2;
                layoutParams.height = b2;
                this.e.setLayoutParams(layoutParams);
            }
            d(ab0.f().q());
            e();
        }
    }

    public void setSearchGuideShowing(boolean z) {
        LiveSearchGuideView liveSearchGuideView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (liveSearchGuideView = this.g) == null) {
            return;
        }
        liveSearchGuideView.setVisibility(z ? 0 : 8);
        ViewGroup.LayoutParams layoutParams = this.g.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (this.e.getVisibility() == 0) {
                layoutParams2.addRule(15);
            } else {
                layoutParams2.addRule(8, R.id.obfuscated_res_0x7f09134f);
                layoutParams2.bottomMargin = (int) TypedValue.applyDimension(1, 7.0f, getResources().getDisplayMetrics());
            }
            this.g.setLayoutParams(layoutParams2);
        }
    }
}
