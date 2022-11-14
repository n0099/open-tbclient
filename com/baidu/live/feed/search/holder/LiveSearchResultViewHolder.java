package com.baidu.live.feed.search.holder;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tieba.R;
import com.baidu.tieba.vc0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010;\u001a\u00020\u000e\u0012\u0006\u0010<\u001a\u00020/\u0012\u0006\u00107\u001a\u000206¢\u0006\u0004\b=\u0010>J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\"\u0010\u001f\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0017\u001a\u0004\b*\u0010\u0019\"\u0004\b+\u0010\u001bR\"\u0010,\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0017\u001a\u0004\b-\u0010\u0019\"\u0004\b.\u0010\u001bR\"\u00100\u001a\u00020/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0019\u00107\u001a\u0002068\u0006@\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:¨\u0006?"}, d2 = {"Lcom/baidu/live/feed/search/holder/LiveSearchResultViewHolder;", "androidx/recyclerview/widget/RecyclerView$ViewHolder", "", CriusAttrConstants.POSITION, "", "bindData", "(I)V", "Lcom/facebook/drawee/view/SimpleDraweeView;", "avatar", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getAvatar", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "setAvatar", "(Lcom/facebook/drawee/view/SimpleDraweeView;)V", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "Landroid/widget/TextView;", "description", "Landroid/widget/TextView;", "getDescription", "()Landroid/widget/TextView;", "setDescription", "(Landroid/widget/TextView;)V", "followed", "getFollowed", "setFollowed", "livingTag", "getLivingTag", "setLivingTag", "Lcom/airbnb/lottie/LottieAnimationView;", "lottieAnimation", "Lcom/airbnb/lottie/LottieAnimationView;", "getLottieAnimation", "()Lcom/airbnb/lottie/LottieAnimationView;", "setLottieAnimation", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "name", "getName", "setName", "nameMid", "getNameMid", "setNameMid", "Landroid/view/View;", "resultContain", "Landroid/view/View;", "getResultContain", "()Landroid/view/View;", "setResultContain", "(Landroid/view/View;)V", "", "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "mContext", "mView", "<init>", "(Landroid/content/Context;Landroid/view/View;Ljava/lang/String;)V", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveSearchResultViewHolder extends RecyclerView.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public TextView c;
    public View d;
    public SimpleDraweeView e;
    public LottieAnimationView f;
    public TextView g;
    public TextView h;
    public Context i;
    public final String j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveSearchResultViewHolder(Context context, View view2, String str) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, str};
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
        this.j = str;
        View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f0913de);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "mView.findViewById(R.id.…_search_result_item_name)");
        this.a = (TextView) findViewById;
        View findViewById2 = view2.findViewById(R.id.obfuscated_res_0x7f0913df);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "mView.findViewById(R.id.…rch_result_item_name_mid)");
        this.h = (TextView) findViewById2;
        View findViewById3 = view2.findViewById(R.id.obfuscated_res_0x7f0913dc);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "mView.findViewById(R.id.…earch_result_item_avatar)");
        this.e = (SimpleDraweeView) findViewById3;
        View findViewById4 = view2.findViewById(R.id.obfuscated_res_0x7f0913d9);
        Intrinsics.checkExpressionValueIsNotNull(findViewById4, "mView.findViewById(R.id.…search_result__item_info)");
        this.b = (TextView) findViewById4;
        View findViewById5 = view2.findViewById(R.id.obfuscated_res_0x7f0913dd);
        Intrinsics.checkExpressionValueIsNotNull(findViewById5, "mView.findViewById(R.id.…earch_result_item_follow)");
        this.c = (TextView) findViewById5;
        View findViewById6 = view2.findViewById(R.id.obfuscated_res_0x7f090fc5);
        Intrinsics.checkExpressionValueIsNotNull(findViewById6, "mView.findViewById(R.id.item_contain)");
        this.d = findViewById6;
        View findViewById7 = view2.findViewById(R.id.obfuscated_res_0x7f0913c1);
        Intrinsics.checkExpressionValueIsNotNull(findViewById7, "mView.findViewById(R.id.…t_item_status_tag_lottie)");
        this.f = (LottieAnimationView) findViewById7;
        View findViewById8 = view2.findViewById(R.id.obfuscated_res_0x7f0913c0);
        Intrinsics.checkExpressionValueIsNotNull(findViewById8, "mView.findViewById(R.id.…ank_list_item_living_tag)");
        this.g = (TextView) findViewById8;
        this.i = context;
    }

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (Intrinsics.areEqual("recommend", this.j)) {
                this.a.setTypeface(Typeface.DEFAULT);
                this.a.setTextSize(1, 14.0f);
            } else {
                this.a.setTypeface(Typeface.DEFAULT_BOLD);
                this.a.setTextSize(1, 16.0f);
            }
            this.e.getHierarchy().setPlaceholderImage(vc0.f().l(this.j), ScalingUtils.ScaleType.FIT_XY);
            TextView textView = this.a;
            vc0 f = vc0.f();
            View itemView = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(itemView, "itemView");
            textView.setTextColor(f.a(itemView.getContext(), this.j, "color_1F1F1F"));
            TextView textView2 = this.g;
            vc0 f2 = vc0.f();
            View itemView2 = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(itemView2, "itemView");
            textView2.setTextColor(f2.a(itemView2.getContext(), this.j, "color_white3"));
            vc0 f3 = vc0.f();
            Intrinsics.checkExpressionValueIsNotNull(f3, "UIModeUtils.getInstance()");
            String r = f3.r();
            if (Intrinsics.areEqual(r, "day")) {
                this.g.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d6d);
            } else if (Intrinsics.areEqual(r, "night")) {
                this.g.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d6e);
            }
        }
    }

    public final SimpleDraweeView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (SimpleDraweeView) invokeV.objValue;
    }

    public final TextView c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (TextView) invokeV.objValue;
    }

    public final TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (TextView) invokeV.objValue;
    }

    public final TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (TextView) invokeV.objValue;
    }

    public final LottieAnimationView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.f;
        }
        return (LottieAnimationView) invokeV.objValue;
    }

    public final TextView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a;
        }
        return (TextView) invokeV.objValue;
    }

    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.i;
        }
        return (Context) invokeV.objValue;
    }

    public final TextView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return (TextView) invokeV.objValue;
    }

    public final View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.d;
        }
        return (View) invokeV.objValue;
    }
}
