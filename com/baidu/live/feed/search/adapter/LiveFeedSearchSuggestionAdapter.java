package com.baidu.live.feed.search.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter;
import com.baidu.live.feed.search.holder.LiveSearchResultViewHolder;
import com.baidu.live.feed.search.model.data.LiveSearchSuggestion;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
import com.repackage.ab0;
import com.repackage.m80;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 E2\u00020\u0001:\u0003EFGB\u0017\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u00105\u001a\u00020\u0017¢\u0006\u0004\bC\u0010DJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ9\u0010#\u001a\u00020\n2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001d2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b#\u0010$J\u001d\u0010'\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0002¢\u0006\u0004\b'\u0010(R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010)R\u0019\u0010+\u001a\u00020*8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R*\u0010/\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0019\u00105\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010)\u001a\u0004\b6\u00107R\u001e\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u00100R$\u00109\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R.\u0010A\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010?j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010B¨\u0006H"}, d2 = {"Lcom/baidu/live/feed/search/adapter/LiveFeedSearchSuggestionAdapter;", "androidx/recyclerview/widget/RecyclerView$Adapter", "", "getItemCount", "()I", CriusAttrConstants.POSITION, "getItemViewType", "(I)I", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/baidu/live/feed/search/holder/LiveSearchResultViewHolder;", "resultDataProcess", "(ILcom/baidu/live/feed/search/holder/LiveSearchResultViewHolder;)V", "setFollowStatus", "(I)V", "", "context", "totalText", "Landroid/text/SpannableString;", "setResultColor", "(Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;", "", "Lcom/baidu/live/business/model/data/LiveSearchResultInfo;", "searchList", "Lcom/baidu/live/feed/search/model/data/LiveSearchSuggestion;", "suggestionList", "contentText", "setSuggestions", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "content", "num", "wordNumCheck", "(Ljava/lang/String;I)Ljava/lang/String;", "Ljava/lang/String;", "Landroid/content/Context;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "resultList", "Ljava/util/List;", "getResultList", "()Ljava/util/List;", "setResultList", "(Ljava/util/List;)V", "scene", "getScene", "()Ljava/lang/String;", "Lcom/baidu/live/feed/search/adapter/LiveFeedSearchSuggestionAdapter$OnSuggestionListener;", "suggestionListener", "Lcom/baidu/live/feed/search/adapter/LiveFeedSearchSuggestionAdapter$OnSuggestionListener;", "getSuggestionListener", "()Lcom/baidu/live/feed/search/adapter/LiveFeedSearchSuggestionAdapter$OnSuggestionListener;", "setSuggestionListener", "(Lcom/baidu/live/feed/search/adapter/LiveFeedSearchSuggestionAdapter$OnSuggestionListener;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "typeList", "Ljava/util/ArrayList;", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "Companion", "OnSuggestionListener", "SearchSuggestionViewHolder", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class LiveFeedSearchSuggestionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Companion Companion;
    public static final int ITEM_TYPE_SUG = 1;
    public static final int ITEM_TYPE_TEXT = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public String contentText;
    public final Context mContext;
    public List<? extends LiveSearchResultInfo> resultList;
    public final String scene;
    public List<? extends LiveSearchSuggestion> suggestionList;
    public OnSuggestionListener suggestionListener;
    public ArrayList<Integer> typeList;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/baidu/live/feed/search/adapter/LiveFeedSearchSuggestionAdapter$Companion;", "", "ITEM_TYPE_SUG", "I", "ITEM_TYPE_TEXT", "<init>", "()V", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0012\u0010\u0011J/\u0010\u0016\u001a\u00020\u00042\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00132\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/baidu/live/feed/search/adapter/LiveFeedSearchSuggestionAdapter$OnSuggestionListener;", "Lkotlin/Any;", "", "jumpScheme", "", "jumpAuthorView", "(Ljava/lang/String;)V", "Lcom/baidu/live/business/model/data/LiveSearchResultInfo;", "itemInfo", "", CriusAttrConstants.POSITION, "onFollowClick", "(Lcom/baidu/live/business/model/data/LiveSearchResultInfo;I)V", "onResultClick", "(Lcom/baidu/live/business/model/data/LiveSearchResultInfo;)V", "content", "onSuggestionClick", "(Ljava/lang/String;I)V", "onSuggestionSelect", "", "resultList", "ubcType", "onUbcResult", "(Ljava/util/List;ILjava/lang/String;)V", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface OnSuggestionListener {
        void jumpAuthorView(String str);

        void onFollowClick(LiveSearchResultInfo liveSearchResultInfo, int i);

        void onResultClick(LiveSearchResultInfo liveSearchResultInfo);

        void onSuggestionClick(String str, int i);

        void onSuggestionSelect(String str, int i);

        void onUbcResult(List<? extends LiveSearchResultInfo> list, int i, String str);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\"\u0010#J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0019\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/baidu/live/feed/search/adapter/LiveFeedSearchSuggestionAdapter$SearchSuggestionViewHolder;", "androidx/recyclerview/widget/RecyclerView$ViewHolder", "", "bindView", "()V", "Landroid/content/Context;", "mContext", "Landroid/content/Context;", "Landroid/view/View;", "mView", "Landroid/view/View;", "getMView", "()Landroid/view/View;", "setMView", "(Landroid/view/View;)V", "", "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "Landroid/widget/ImageView;", "suggestionArrow", "Landroid/widget/ImageView;", "getSuggestionArrow", "()Landroid/widget/ImageView;", "setSuggestionArrow", "(Landroid/widget/ImageView;)V", "Landroid/widget/TextView;", "suggestionWordContent", "Landroid/widget/TextView;", "getSuggestionWordContent", "()Landroid/widget/TextView;", "setSuggestionWordContent", "(Landroid/widget/TextView;)V", "<init>", "(Landroid/content/Context;Landroid/view/View;Ljava/lang/String;)V", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static class SearchSuggestionViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context mContext;
        public View mView;
        public final String scene;
        public ImageView suggestionArrow;
        public TextView suggestionWordContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SearchSuggestionViewHolder(Context context, View view2, String str) {
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
            this.mContext = context;
            this.mView = view2;
            this.scene = str;
            View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f09138e);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "mView.findViewById(R.id.…earch_suggestion_content)");
            this.suggestionWordContent = (TextView) findViewById;
            View findViewById2 = this.mView.findViewById(R.id.obfuscated_res_0x7f09138d);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "mView.findViewById(R.id.…arch_suggestion_arrow_iv)");
            this.suggestionArrow = (ImageView) findViewById2;
        }

        public final void bindView() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (Intrinsics.areEqual(this.scene, "recommend")) {
                    this.suggestionWordContent.setTypeface(Typeface.DEFAULT);
                    this.suggestionWordContent.setTextSize(1, 14.0f);
                } else {
                    this.suggestionWordContent.setTypeface(Typeface.DEFAULT_BOLD);
                    this.suggestionWordContent.setTextSize(1, 16.0f);
                }
                this.suggestionWordContent.setTextColor(ab0.f().a(this.mContext, this.scene, "color_1F1F1F"));
                ab0 f = ab0.f();
                Intrinsics.checkExpressionValueIsNotNull(f, "UIModeUtils.getInstance()");
                String q = f.q();
                if (Intrinsics.areEqual(q, "day")) {
                    this.suggestionArrow.setImageResource(R.drawable.obfuscated_res_0x7f080d17);
                } else if (Intrinsics.areEqual(q, "night")) {
                    this.suggestionArrow.setImageResource(R.drawable.obfuscated_res_0x7f080d18);
                }
            }
        }

        public final View getMView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mView : (View) invokeV.objValue;
        }

        public final String getScene() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.scene : (String) invokeV.objValue;
        }

        public final ImageView getSuggestionArrow() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.suggestionArrow : (ImageView) invokeV.objValue;
        }

        public final TextView getSuggestionWordContent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.suggestionWordContent : (TextView) invokeV.objValue;
        }

        public final void setMView(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
                this.mView = view2;
            }
        }

        public final void setSuggestionArrow(ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, imageView) == null) {
                this.suggestionArrow = imageView;
            }
        }

        public final void setSuggestionWordContent(TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, textView) == null) {
                this.suggestionWordContent = textView;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(70805101, "Lcom/baidu/live/feed/search/adapter/LiveFeedSearchSuggestionAdapter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(70805101, "Lcom/baidu/live/feed/search/adapter/LiveFeedSearchSuggestionAdapter;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    public LiveFeedSearchSuggestionAdapter(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.scene = str;
        this.typeList = new ArrayList<>();
    }

    private final SpannableString setResultColor(String str, String str2) {
        InterceptResult invokeLL;
        CharacterStyle characterStyle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, str2)) == null) {
            SpannableString spannableString = new SpannableString(str2);
            if (Intrinsics.areEqual("recommend", this.scene)) {
                characterStyle = new CharacterStyle(this) { // from class: com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter$setResultColor$replaySpan$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LiveFeedSearchSuggestionAdapter this$0;

                    /* JADX DEBUG: Incorrect args count in method signature: ()V */
                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, textPaint) == null) {
                            textPaint.setColor(this.this$0.getMContext().getResources().getColor(R.color.obfuscated_res_0x7f060787));
                            textPaint.bgColor = 0;
                            textPaint.setTextSize(m80.c(this.this$0.getMContext().getResources(), 14.0f));
                            textPaint.setUnderlineText(false);
                        }
                    }
                };
            } else {
                characterStyle = new CharacterStyle() { // from class: com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter$setResultColor$replaySpan$2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    @Override // android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, textPaint) == null) {
                            textPaint.bgColor = 0;
                            textPaint.setTypeface(Typeface.DEFAULT);
                            textPaint.setUnderlineText(false);
                        }
                    }
                };
            }
            int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str2, str, 0, false, 6, (Object) null);
            int length = str.length();
            if (indexOf$default >= 0) {
                spannableString.setSpan(characterStyle, indexOf$default, length + indexOf$default, 33);
            }
            return spannableString;
        }
        return (SpannableString) invokeLL.objValue;
    }

    public static /* synthetic */ void setSuggestions$default(LiveFeedSearchSuggestionAdapter liveFeedSearchSuggestionAdapter, List list, List list2, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        liveFeedSearchSuggestionAdapter.setSuggestions(list, list2, str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<? extends LiveSearchResultInfo> list = this.resultList;
            int size = list != null ? list.size() : 0;
            List<? extends LiveSearchSuggestion> list2 = this.suggestionList;
            return size + (list2 != null ? list2.size() : 0);
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            ArrayList<Integer> arrayList = this.typeList;
            if (arrayList == null || (num = arrayList.get(i)) == null) {
                return -1;
            }
            return num.intValue();
        }
        return invokeI.intValue;
    }

    public final Context getMContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mContext : (Context) invokeV.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: java.util.List<? extends com.baidu.live.business.model.data.LiveSearchResultInfo>, java.util.List<com.baidu.live.business.model.data.LiveSearchResultInfo> */
    public final List<LiveSearchResultInfo> getResultList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.resultList : (List) invokeV.objValue;
    }

    public final String getScene() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.scene : (String) invokeV.objValue;
    }

    public final OnSuggestionListener getSuggestionListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.suggestionListener : (OnSuggestionListener) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        String str;
        LiveSearchSuggestion liveSearchSuggestion;
        OnSuggestionListener onSuggestionListener;
        String str2;
        LiveSearchResultInfo liveSearchResultInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, viewHolder, i) == null) {
            int itemViewType = getItemViewType(i);
            SpannableString spannableString = null;
            if (itemViewType == 0) {
                Ref.IntRef intRef = new Ref.IntRef();
                List<? extends LiveSearchResultInfo> list = this.resultList;
                int size = i - (list != null ? list.size() : 0);
                intRef.element = size;
                List<? extends LiveSearchSuggestion> list2 = this.suggestionList;
                String str3 = (list2 == null || (liveSearchSuggestion = list2.get(size)) == null) ? null : liveSearchSuggestion.question;
                SearchSuggestionViewHolder searchSuggestionViewHolder = (SearchSuggestionViewHolder) viewHolder;
                searchSuggestionViewHolder.bindView();
                TextView suggestionWordContent = searchSuggestionViewHolder.getSuggestionWordContent();
                if (str3 != null && (str = this.contentText) != null) {
                    spannableString = setResultColor(str, str3);
                }
                suggestionWordContent.setText(spannableString);
                searchSuggestionViewHolder.itemView.setOnClickListener(new View.OnClickListener(this, intRef) { // from class: com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter$onBindViewHolder$4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Ref.IntRef $textPos;
                    public final /* synthetic */ LiveFeedSearchSuggestionAdapter this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, intRef};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.$textPos = intRef;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:4:0x0004, code lost:
                        r5 = r4.this$0.suggestionList;
                     */
                    @Override // android.view.View.OnClickListener
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void onClick(View view2) {
                        List list3;
                        LiveSearchSuggestion liveSearchSuggestion2;
                        String str4;
                        LiveFeedSearchSuggestionAdapter.OnSuggestionListener suggestionListener;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) || list3 == null || (liveSearchSuggestion2 = (LiveSearchSuggestion) list3.get(this.$textPos.element)) == null || (str4 = liveSearchSuggestion2.question) == null || (suggestionListener = this.this$0.getSuggestionListener()) == null) {
                            return;
                        }
                        suggestionListener.onSuggestionClick(str4, this.$textPos.element);
                    }
                });
                searchSuggestionViewHolder.getSuggestionArrow().setOnClickListener(new View.OnClickListener(this, intRef) { // from class: com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter$onBindViewHolder$5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Ref.IntRef $textPos;
                    public final /* synthetic */ LiveFeedSearchSuggestionAdapter this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, intRef};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.$textPos = intRef;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:4:0x0004, code lost:
                        r5 = r4.this$0.suggestionList;
                     */
                    @Override // android.view.View.OnClickListener
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void onClick(View view2) {
                        List list3;
                        LiveSearchSuggestion liveSearchSuggestion2;
                        String str4;
                        LiveFeedSearchSuggestionAdapter.OnSuggestionListener suggestionListener;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) || list3 == null || (liveSearchSuggestion2 = (LiveSearchSuggestion) list3.get(this.$textPos.element)) == null || (str4 = liveSearchSuggestion2.question) == null || (suggestionListener = this.this$0.getSuggestionListener()) == null) {
                            return;
                        }
                        suggestionListener.onSuggestionSelect(str4, this.$textPos.element);
                    }
                });
            } else if (itemViewType != 1) {
            } else {
                LiveSearchResultViewHolder liveSearchResultViewHolder = (LiveSearchResultViewHolder) viewHolder;
                resultDataProcess(i, liveSearchResultViewHolder);
                liveSearchResultViewHolder.a(i);
                List<? extends LiveSearchResultInfo> list3 = this.resultList;
                String str4 = (list3 == null || (liveSearchResultInfo = list3.get(i)) == null) ? null : liveSearchResultInfo.question;
                TextView g = liveSearchResultViewHolder.g();
                if (str4 != null && (str2 = this.contentText) != null) {
                    spannableString = setResultColor(str2, str4);
                }
                g.setText(spannableString);
                List<? extends LiveSearchResultInfo> list4 = this.resultList;
                if (list4 == null || (onSuggestionListener = this.suggestionListener) == null) {
                    return;
                }
                onSuggestionListener.onUbcResult(list4, i, "show");
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, viewGroup, i)) == null) {
            if (i == 1) {
                View view2 = View.inflate(this.mContext, R.layout.obfuscated_res_0x7f0d0547, null);
                Context context = this.mContext;
                Intrinsics.checkExpressionValueIsNotNull(view2, "view");
                return new LiveSearchResultViewHolder(context, view2, this.scene);
            }
            View view3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0542, viewGroup, false);
            Context context2 = this.mContext;
            Intrinsics.checkExpressionValueIsNotNull(view3, "view");
            return new SearchSuggestionViewHolder(context2, view3, this.scene);
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public final void resultDataProcess(int i, LiveSearchResultViewHolder liveSearchResultViewHolder) {
        LiveSearchResultInfo liveSearchResultInfo;
        String str;
        LiveSearchResultInfo liveSearchResultInfo2;
        LiveSearchResultInfo liveSearchResultInfo3;
        LiveSearchResultInfo liveSearchResultInfo4;
        LiveSearchResultInfo liveSearchResultInfo5;
        String str2;
        LiveSearchResultInfo liveSearchResultInfo6;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, liveSearchResultViewHolder) == null) {
            List<? extends LiveSearchResultInfo> list = this.resultList;
            Boolean bool = null;
            LiveSearchResultInfo liveSearchResultInfo7 = list != null ? list.get(i) : null;
            if ((liveSearchResultInfo7 != null ? liveSearchResultInfo7.description : null) != null) {
                liveSearchResultViewHolder.g().setVisibility(0);
                liveSearchResultViewHolder.h().setVisibility(8);
                TextView g = liveSearchResultViewHolder.g();
                List<? extends LiveSearchResultInfo> list2 = this.resultList;
                g.setText((list2 == null || (liveSearchResultInfo6 = list2.get(i)) == null || (str3 = liveSearchResultInfo6.displayName) == null) ? null : wordNumCheck(str3, 8));
            } else {
                liveSearchResultViewHolder.g().setVisibility(8);
                liveSearchResultViewHolder.h().setVisibility(0);
                TextView h = liveSearchResultViewHolder.h();
                List<? extends LiveSearchResultInfo> list3 = this.resultList;
                h.setText((list3 == null || (liveSearchResultInfo = list3.get(i)) == null || (str = liveSearchResultInfo.displayName) == null) ? null : wordNumCheck(str, 8));
            }
            TextView c = liveSearchResultViewHolder.c();
            List<? extends LiveSearchResultInfo> list4 = this.resultList;
            c.setText((list4 == null || (liveSearchResultInfo5 = list4.get(i)) == null || (str2 = liveSearchResultInfo5.description) == null) ? null : wordNumCheck(str2, 14));
            CharSequence text = liveSearchResultViewHolder.c().getText();
            if (text == null || text.length() == 0) {
                liveSearchResultViewHolder.c().setVisibility(8);
                liveSearchResultViewHolder.g().setGravity(16);
            }
            SimpleDraweeView b = liveSearchResultViewHolder.b();
            List<? extends LiveSearchResultInfo> list5 = this.resultList;
            b.setImageURI((list5 == null || (liveSearchResultInfo4 = list5.get(i)) == null) ? null : liveSearchResultInfo4.avatar);
            List<? extends LiveSearchResultInfo> list6 = this.resultList;
            if (list6 != null && (liveSearchResultInfo3 = list6.get(i)) != null && liveSearchResultInfo3.hasFollowed) {
                if (Intrinsics.areEqual(this.scene, "recommend")) {
                    liveSearchResultViewHolder.d().setVisibility(8);
                } else {
                    liveSearchResultViewHolder.d().setVisibility(0);
                    liveSearchResultViewHolder.d().setText("已关注");
                    liveSearchResultViewHolder.d().setTypeface(Typeface.DEFAULT);
                    liveSearchResultViewHolder.d().setTextColor(ab0.f().a(liveSearchResultViewHolder.getContext(), this.scene, "color_8585852"));
                    ab0 f = ab0.f();
                    Intrinsics.checkExpressionValueIsNotNull(f, "UIModeUtils.getInstance()");
                    String q = f.q();
                    if (Intrinsics.areEqual(q, "day")) {
                        liveSearchResultViewHolder.d().setBackgroundResource(R.drawable.obfuscated_res_0x7f080cf0);
                    } else if (Intrinsics.areEqual(q, "night")) {
                        liveSearchResultViewHolder.d().setBackgroundResource(R.drawable.obfuscated_res_0x7f080cf1);
                    }
                }
            } else {
                liveSearchResultViewHolder.d().setVisibility(0);
                liveSearchResultViewHolder.d().setText("关注");
                liveSearchResultViewHolder.d().setTypeface(Typeface.DEFAULT_BOLD);
                liveSearchResultViewHolder.d().setTextColor(ab0.f().a(liveSearchResultViewHolder.getContext(), this.scene, "color_white3"));
                ab0 f2 = ab0.f();
                Intrinsics.checkExpressionValueIsNotNull(f2, "UIModeUtils.getInstance()");
                String q2 = f2.q();
                if (Intrinsics.areEqual(q2, "day")) {
                    liveSearchResultViewHolder.d().setBackgroundResource(R.drawable.obfuscated_res_0x7f080cee);
                } else if (Intrinsics.areEqual(q2, "night")) {
                    liveSearchResultViewHolder.d().setBackgroundResource(R.drawable.obfuscated_res_0x7f080cef);
                }
            }
            liveSearchResultViewHolder.f().setVisibility(8);
            liveSearchResultViewHolder.e().setVisibility(8);
            List<? extends LiveSearchResultInfo> list7 = this.resultList;
            if (list7 != null && (liveSearchResultInfo2 = list7.get(i)) != null) {
                bool = Boolean.valueOf(liveSearchResultInfo2.hasLiving);
            }
            if (bool == null) {
                Intrinsics.throwNpe();
            }
            if (bool.booleanValue()) {
                liveSearchResultViewHolder.f().setVisibility(0);
                liveSearchResultViewHolder.e().setVisibility(0);
                ab0 f3 = ab0.f();
                Intrinsics.checkExpressionValueIsNotNull(f3, "UIModeUtils.getInstance()");
                String q3 = f3.q();
                if (Intrinsics.areEqual(q3, "day")) {
                    liveSearchResultViewHolder.f().setAnimation("lottie/liveshow_rank_avatar_live_tag_day.json");
                } else if (Intrinsics.areEqual(q3, "night")) {
                    liveSearchResultViewHolder.f().setAnimation("lottie/liveshow_rank_avatar_live_tag_night.json");
                }
                liveSearchResultViewHolder.f().playAnimation();
            } else {
                liveSearchResultViewHolder.f().setVisibility(8);
                liveSearchResultViewHolder.e().setVisibility(8);
                liveSearchResultViewHolder.i().setVisibility(8);
            }
            liveSearchResultViewHolder.i().setOnClickListener(new View.OnClickListener(this, i) { // from class: com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter$resultDataProcess$4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int $position;
                public final /* synthetic */ LiveFeedSearchSuggestionAdapter this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$position = i;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LiveSearchResultInfo liveSearchResultInfo8;
                    String str4;
                    LiveFeedSearchSuggestionAdapter.OnSuggestionListener suggestionListener;
                    LiveSearchResultInfo liveSearchResultInfo9;
                    LiveFeedSearchSuggestionAdapter.OnSuggestionListener suggestionListener2;
                    LiveSearchResultInfo liveSearchResultInfo10;
                    String str5;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        List<LiveSearchResultInfo> resultList = this.this$0.getResultList();
                        LiveSearchResultInfo liveSearchResultInfo11 = resultList != null ? resultList.get(this.$position) : null;
                        if (liveSearchResultInfo11 == null) {
                            Intrinsics.throwNpe();
                        }
                        String str6 = "";
                        if (liveSearchResultInfo11.hasLiving) {
                            List<LiveSearchResultInfo> resultList2 = this.this$0.getResultList();
                            if (resultList2 != null && (liveSearchResultInfo10 = resultList2.get(this.$position)) != null && (str5 = liveSearchResultInfo10.cmd) != null) {
                                str6 = str5;
                            }
                            LiveFeedPageSdk.liveLog("FeedItemClick: position: " + this.$position + "  scheme: " + str6);
                            List<LiveSearchResultInfo> resultList3 = this.this$0.getResultList();
                            if (resultList3 != null && (liveSearchResultInfo9 = resultList3.get(this.$position)) != null && (suggestionListener2 = this.this$0.getSuggestionListener()) != null) {
                                suggestionListener2.onResultClick(liveSearchResultInfo9);
                            }
                        } else {
                            List<LiveSearchResultInfo> resultList4 = this.this$0.getResultList();
                            if (resultList4 != null && (liveSearchResultInfo8 = resultList4.get(this.$position)) != null && (str4 = liveSearchResultInfo8.cmd) != null) {
                                str6 = str4;
                            }
                            LiveFeedPageSdk.liveLog("FeedItemClick: position: " + this.$position + "  scheme: " + str6);
                            LiveFeedSearchSuggestionAdapter.OnSuggestionListener suggestionListener3 = this.this$0.getSuggestionListener();
                            if (suggestionListener3 != null) {
                                suggestionListener3.jumpAuthorView(str6);
                            }
                        }
                        List<LiveSearchResultInfo> resultList5 = this.this$0.getResultList();
                        if (resultList5 == null || (suggestionListener = this.this$0.getSuggestionListener()) == null) {
                            return;
                        }
                        suggestionListener.onUbcResult(resultList5, this.$position, "clk");
                    }
                }
            });
            liveSearchResultViewHolder.d().setOnClickListener(new View.OnClickListener(this, i) { // from class: com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter$resultDataProcess$5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int $position;
                public final /* synthetic */ LiveFeedSearchSuggestionAdapter this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$position = i;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LiveFeedSearchSuggestionAdapter.OnSuggestionListener suggestionListener;
                    LiveSearchResultInfo liveSearchResultInfo8;
                    LiveFeedSearchSuggestionAdapter.OnSuggestionListener suggestionListener2;
                    LiveFeedSearchSuggestionAdapter.OnSuggestionListener suggestionListener3;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        List<LiveSearchResultInfo> resultList = this.this$0.getResultList();
                        if (resultList == null) {
                            Intrinsics.throwNpe();
                        }
                        LiveSearchResultInfo liveSearchResultInfo9 = resultList.get(this.$position);
                        Boolean valueOf = liveSearchResultInfo9 != null ? Boolean.valueOf(liveSearchResultInfo9.hasFollowed) : null;
                        if (valueOf == null) {
                            Intrinsics.throwNpe();
                        }
                        if (!valueOf.booleanValue()) {
                            List<LiveSearchResultInfo> resultList2 = this.this$0.getResultList();
                            if (resultList2 == null) {
                                Intrinsics.throwNpe();
                            }
                            LiveSearchResultInfo liveSearchResultInfo10 = resultList2.get(this.$position);
                            if (liveSearchResultInfo10 == null || (suggestionListener3 = this.this$0.getSuggestionListener()) == null) {
                                return;
                            }
                            suggestionListener3.onFollowClick(liveSearchResultInfo10, this.$position);
                            return;
                        }
                        List<LiveSearchResultInfo> resultList3 = this.this$0.getResultList();
                        if (resultList3 != null && (liveSearchResultInfo8 = resultList3.get(this.$position)) != null && (suggestionListener2 = this.this$0.getSuggestionListener()) != null) {
                            suggestionListener2.onResultClick(liveSearchResultInfo8);
                        }
                        List<LiveSearchResultInfo> resultList4 = this.this$0.getResultList();
                        if (resultList4 == null || (suggestionListener = this.this$0.getSuggestionListener()) == null) {
                            return;
                        }
                        suggestionListener.onUbcResult(resultList4, this.$position, "clk");
                    }
                }
            });
            StaggeredGridLayoutManager.LayoutParams layoutParams = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
            layoutParams.setFullSpan(true);
            View view2 = liveSearchResultViewHolder.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view2, "holder.itemView");
            view2.setLayoutParams(layoutParams);
        }
    }

    public final void setFollowStatus(int i) {
        LiveSearchResultInfo liveSearchResultInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            List<? extends LiveSearchResultInfo> list = this.resultList;
            if (!(list == null || list.isEmpty()) && i >= 0) {
                List<? extends LiveSearchResultInfo> list2 = this.resultList;
                if (list2 == null) {
                    Intrinsics.throwNpe();
                }
                if (i >= list2.size()) {
                    return;
                }
                List<? extends LiveSearchResultInfo> list3 = this.resultList;
                if (list3 != null && (liveSearchResultInfo = list3.get(i)) != null) {
                    liveSearchResultInfo.hasFollowed = true;
                }
                notifyItemChanged(i);
            }
        }
    }

    public final void setResultList(List<? extends LiveSearchResultInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            this.resultList = list;
        }
    }

    public final void setSuggestionListener(OnSuggestionListener onSuggestionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onSuggestionListener) == null) {
            this.suggestionListener = onSuggestionListener;
        }
    }

    public final void setSuggestions(List<? extends LiveSearchResultInfo> list, List<? extends LiveSearchSuggestion> list2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, list, list2, str) == null) {
            this.resultList = list;
            this.suggestionList = list2;
            this.contentText = str;
            ArrayList<Integer> arrayList = this.typeList;
            if (arrayList != null) {
                arrayList.clear();
            }
            boolean z = true;
            if (!(list == null || list.isEmpty())) {
                if (!(list2 == null || list2.isEmpty())) {
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        ArrayList<Integer> arrayList2 = this.typeList;
                        if (arrayList2 != null) {
                            arrayList2.add(1);
                        }
                    }
                    int size2 = list.size() + list2.size();
                    for (int size3 = list.size(); size3 < size2; size3++) {
                        ArrayList<Integer> arrayList3 = this.typeList;
                        if (arrayList3 != null) {
                            arrayList3.add(0);
                        }
                    }
                    notifyDataSetChanged();
                }
            }
            if (!(list == null || list.isEmpty())) {
                int intValue = (list != null ? Integer.valueOf(list.size()) : null).intValue();
                for (int i2 = 0; i2 < intValue; i2++) {
                    ArrayList<Integer> arrayList4 = this.typeList;
                    if (arrayList4 != null) {
                        arrayList4.add(1);
                    }
                }
            } else {
                if (list2 != null && !list2.isEmpty()) {
                    z = false;
                }
                if (!z) {
                    int size4 = list2.size();
                    for (int i3 = 0; i3 < size4; i3++) {
                        ArrayList<Integer> arrayList5 = this.typeList;
                        if (arrayList5 != null) {
                            arrayList5.add(0);
                        }
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    public final String wordNumCheck(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, str, i)) == null) {
            if (str.length() > i) {
                StringBuilder sb = new StringBuilder();
                String substring = str.substring(0, i);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb.append(substring);
                sb.append(StringHelper.STRING_MORE);
                return sb.toString();
            }
            return str;
        }
        return (String) invokeLI.objValue;
    }
}
