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
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter;
import com.baidu.live.feed.search.holder.LiveSearchResultViewHolder;
import com.baidu.live.feed.search.model.data.LiveSearchSuggestion;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tieba.R;
import com.baidu.tieba.f60;
import com.baidu.tieba.w80;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 E2\u00020\u0001:\u0003EFGB\u0017\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u00105\u001a\u00020\u0017¢\u0006\u0004\bC\u0010DJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ9\u0010#\u001a\u00020\n2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001d2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b#\u0010$J\u001d\u0010'\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0002¢\u0006\u0004\b'\u0010(R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010)R\u0019\u0010+\u001a\u00020*8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R*\u0010/\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0019\u00105\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010)\u001a\u0004\b6\u00107R\u001e\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u00100R$\u00109\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R.\u0010A\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010?j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010B¨\u0006H"}, d2 = {"Lcom/baidu/live/feed/search/adapter/LiveFeedSearchSuggestionAdapter;", "androidx/recyclerview/widget/RecyclerView$Adapter", "", "getItemCount", "()I", CriusAttrConstants.POSITION, "getItemViewType", "(I)I", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/baidu/live/feed/search/holder/LiveSearchResultViewHolder;", "resultDataProcess", "(ILcom/baidu/live/feed/search/holder/LiveSearchResultViewHolder;)V", "setFollowStatus", "(I)V", "", "context", "totalText", "Landroid/text/SpannableString;", "setResultColor", "(Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;", "", "Lcom/baidu/live/business/model/data/LiveSearchResultInfo;", "searchList", "Lcom/baidu/live/feed/search/model/data/LiveSearchSuggestion;", "suggestionList", "contentText", "setSuggestions", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "content", "num", "wordNumCheck", "(Ljava/lang/String;I)Ljava/lang/String;", "Ljava/lang/String;", "Landroid/content/Context;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "resultList", "Ljava/util/List;", "getResultList", "()Ljava/util/List;", "setResultList", "(Ljava/util/List;)V", "scene", "getScene", "()Ljava/lang/String;", "Lcom/baidu/live/feed/search/adapter/LiveFeedSearchSuggestionAdapter$OnSuggestionListener;", "suggestionListener", "Lcom/baidu/live/feed/search/adapter/LiveFeedSearchSuggestionAdapter$OnSuggestionListener;", "getSuggestionListener", "()Lcom/baidu/live/feed/search/adapter/LiveFeedSearchSuggestionAdapter$OnSuggestionListener;", "setSuggestionListener", "(Lcom/baidu/live/feed/search/adapter/LiveFeedSearchSuggestionAdapter$OnSuggestionListener;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "typeList", "Ljava/util/ArrayList;", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "Companion", "OnSuggestionListener", "SearchSuggestionViewHolder", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class LiveFeedSearchSuggestionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion(null);
    public static final int ITEM_TYPE_SUG = 1;
    public static final int ITEM_TYPE_TEXT = 0;
    public String contentText;
    public final Context mContext;
    public List<? extends LiveSearchResultInfo> resultList;
    public final String scene;
    public List<? extends LiveSearchSuggestion> suggestionList;
    public OnSuggestionListener suggestionListener;
    public ArrayList<Integer> typeList = new ArrayList<>();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0012\u0010\u0011J/\u0010\u0016\u001a\u00020\u00042\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00132\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/baidu/live/feed/search/adapter/LiveFeedSearchSuggestionAdapter$OnSuggestionListener;", "Lkotlin/Any;", "", "jumpScheme", "", "jumpAuthorView", "(Ljava/lang/String;)V", "Lcom/baidu/live/business/model/data/LiveSearchResultInfo;", "itemInfo", "", CriusAttrConstants.POSITION, "onFollowClick", "(Lcom/baidu/live/business/model/data/LiveSearchResultInfo;I)V", "onResultClick", "(Lcom/baidu/live/business/model/data/LiveSearchResultInfo;)V", "content", "onSuggestionClick", "(Ljava/lang/String;I)V", "onSuggestionSelect", "", "resultList", "ubcType", "onUbcResult", "(Ljava/util/List;ILjava/lang/String;)V", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public interface OnSuggestionListener {
        void jumpAuthorView(String str);

        void onFollowClick(LiveSearchResultInfo liveSearchResultInfo, int i);

        void onResultClick(LiveSearchResultInfo liveSearchResultInfo);

        void onSuggestionClick(String str, int i);

        void onSuggestionSelect(String str, int i);

        void onUbcResult(List<? extends LiveSearchResultInfo> list, int i, String str);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/baidu/live/feed/search/adapter/LiveFeedSearchSuggestionAdapter$Companion;", "", "ITEM_TYPE_SUG", "I", "ITEM_TYPE_TEXT", "<init>", "()V", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\"\u0010#J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0019\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/baidu/live/feed/search/adapter/LiveFeedSearchSuggestionAdapter$SearchSuggestionViewHolder;", "androidx/recyclerview/widget/RecyclerView$ViewHolder", "", "bindView", "()V", "Landroid/content/Context;", "mContext", "Landroid/content/Context;", "Landroid/view/View;", "mView", "Landroid/view/View;", "getMView", "()Landroid/view/View;", "setMView", "(Landroid/view/View;)V", "", "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "Landroid/widget/ImageView;", "suggestionArrow", "Landroid/widget/ImageView;", "getSuggestionArrow", "()Landroid/widget/ImageView;", "setSuggestionArrow", "(Landroid/widget/ImageView;)V", "Landroid/widget/TextView;", "suggestionWordContent", "Landroid/widget/TextView;", "getSuggestionWordContent", "()Landroid/widget/TextView;", "setSuggestionWordContent", "(Landroid/widget/TextView;)V", "<init>", "(Landroid/content/Context;Landroid/view/View;Ljava/lang/String;)V", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static class SearchSuggestionViewHolder extends RecyclerView.ViewHolder {
        public final Context mContext;
        public View mView;
        public final String scene;
        public ImageView suggestionArrow;
        public TextView suggestionWordContent;

        public SearchSuggestionViewHolder(Context context, View view2, String str) {
            super(view2);
            this.mContext = context;
            this.mView = view2;
            this.scene = str;
            View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f091621);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "mView.findViewById(R.id.…earch_suggestion_content)");
            this.suggestionWordContent = (TextView) findViewById;
            View findViewById2 = this.mView.findViewById(R.id.obfuscated_res_0x7f091620);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "mView.findViewById(R.id.…arch_suggestion_arrow_iv)");
            this.suggestionArrow = (ImageView) findViewById2;
        }

        public final void bindView() {
            if (Intrinsics.areEqual(this.scene, "recommend")) {
                this.suggestionWordContent.setTypeface(Typeface.DEFAULT);
                this.suggestionWordContent.setTextSize(1, 14.0f);
            } else {
                this.suggestionWordContent.setTypeface(Typeface.DEFAULT_BOLD);
                this.suggestionWordContent.setTextSize(1, 16.0f);
            }
            this.suggestionWordContent.setTextColor(w80.f().a(this.mContext, this.scene, "color_1F1F1F"));
            w80 f = w80.f();
            Intrinsics.checkExpressionValueIsNotNull(f, "UIModeUtils.getInstance()");
            String r = f.r();
            if (Intrinsics.areEqual(r, "day")) {
                this.suggestionArrow.setImageResource(R.drawable.obfuscated_res_0x7f080f92);
            } else if (Intrinsics.areEqual(r, "night")) {
                this.suggestionArrow.setImageResource(R.drawable.obfuscated_res_0x7f080f93);
            }
        }

        public final View getMView() {
            return this.mView;
        }

        public final String getScene() {
            return this.scene;
        }

        public final ImageView getSuggestionArrow() {
            return this.suggestionArrow;
        }

        public final TextView getSuggestionWordContent() {
            return this.suggestionWordContent;
        }

        public final void setMView(View view2) {
            this.mView = view2;
        }

        public final void setSuggestionArrow(ImageView imageView) {
            this.suggestionArrow = imageView;
        }

        public final void setSuggestionWordContent(TextView textView) {
            this.suggestionWordContent = textView;
        }
    }

    public LiveFeedSearchSuggestionAdapter(Context context, String str) {
        this.mContext = context;
        this.scene = str;
    }

    private final SpannableString setResultColor(String str, String str2) {
        CharacterStyle characterStyle;
        SpannableString spannableString = new SpannableString(str2);
        if (Intrinsics.areEqual("recommend", this.scene)) {
            characterStyle = new CharacterStyle() { // from class: com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter$setResultColor$replaySpan$1
                @Override // android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(LiveFeedSearchSuggestionAdapter.this.getMContext().getResources().getColor(R.color.obfuscated_res_0x7f0607c2));
                    textPaint.bgColor = 0;
                    textPaint.setTextSize(f60.c(LiveFeedSearchSuggestionAdapter.this.getMContext().getResources(), 14.0f));
                    textPaint.setUnderlineText(false);
                }
            };
        } else {
            characterStyle = new CharacterStyle() { // from class: com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter$setResultColor$replaySpan$2
                @Override // android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    textPaint.bgColor = 0;
                    textPaint.setTypeface(Typeface.DEFAULT);
                    textPaint.setUnderlineText(false);
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

    public final String wordNumCheck(String str, int i) {
        if (str.length() > i) {
            StringBuilder sb = new StringBuilder();
            String substring = str.substring(0, i);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb.append(substring);
            sb.append("...");
            return sb.toString();
        }
        return str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        Integer num;
        ArrayList<Integer> arrayList = this.typeList;
        if (arrayList != null && (num = arrayList.get(i)) != null) {
            return num.intValue();
        }
        return -1;
    }

    public final void setResultList(List<? extends LiveSearchResultInfo> list) {
        this.resultList = list;
    }

    public final void setSuggestionListener(OnSuggestionListener onSuggestionListener) {
        this.suggestionListener = onSuggestionListener;
    }

    public static /* synthetic */ void setSuggestions$default(LiveFeedSearchSuggestionAdapter liveFeedSearchSuggestionAdapter, List list, List list2, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        liveFeedSearchSuggestionAdapter.setSuggestions(list, list2, str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int i;
        List<? extends LiveSearchResultInfo> list = this.resultList;
        int i2 = 0;
        if (list != null) {
            i = list.size();
        } else {
            i = 0;
        }
        List<? extends LiveSearchSuggestion> list2 = this.suggestionList;
        if (list2 != null) {
            i2 = list2.size();
        }
        return i + i2;
    }

    public final Context getMContext() {
        return this.mContext;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.baidu.live.business.model.data.LiveSearchResultInfo>, java.util.List<com.baidu.live.business.model.data.LiveSearchResultInfo> */
    public final List<LiveSearchResultInfo> getResultList() {
        return this.resultList;
    }

    public final String getScene() {
        return this.scene;
    }

    public final OnSuggestionListener getSuggestionListener() {
        return this.suggestionListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int i2;
        String str;
        String str2;
        LiveSearchSuggestion liveSearchSuggestion;
        String str3;
        OnSuggestionListener onSuggestionListener;
        String str4;
        LiveSearchResultInfo liveSearchResultInfo;
        int itemViewType = getItemViewType(i);
        SpannableString spannableString = null;
        if (itemViewType != 0) {
            if (itemViewType == 1) {
                LiveSearchResultViewHolder liveSearchResultViewHolder = (LiveSearchResultViewHolder) viewHolder;
                resultDataProcess(i, liveSearchResultViewHolder);
                liveSearchResultViewHolder.a(i);
                List<? extends LiveSearchResultInfo> list = this.resultList;
                if (list != null && (liveSearchResultInfo = list.get(i)) != null) {
                    str3 = liveSearchResultInfo.question;
                } else {
                    str3 = null;
                }
                TextView h = liveSearchResultViewHolder.h();
                if (str3 != null && (str4 = this.contentText) != null) {
                    spannableString = setResultColor(str4, str3);
                }
                h.setText(spannableString);
                List<? extends LiveSearchResultInfo> list2 = this.resultList;
                if (list2 != null && (onSuggestionListener = this.suggestionListener) != null) {
                    onSuggestionListener.onUbcResult(list2, i, "show");
                    return;
                }
                return;
            }
            return;
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        List<? extends LiveSearchResultInfo> list3 = this.resultList;
        if (list3 != null) {
            i2 = list3.size();
        } else {
            i2 = 0;
        }
        int i3 = i - i2;
        intRef.element = i3;
        List<? extends LiveSearchSuggestion> list4 = this.suggestionList;
        if (list4 != null && (liveSearchSuggestion = list4.get(i3)) != null) {
            str = liveSearchSuggestion.question;
        } else {
            str = null;
        }
        SearchSuggestionViewHolder searchSuggestionViewHolder = (SearchSuggestionViewHolder) viewHolder;
        searchSuggestionViewHolder.bindView();
        TextView suggestionWordContent = searchSuggestionViewHolder.getSuggestionWordContent();
        if (str != null && (str2 = this.contentText) != null) {
            spannableString = setResultColor(str2, str);
        }
        suggestionWordContent.setText(spannableString);
        searchSuggestionViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter$onBindViewHolder$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                List list5;
                LiveSearchSuggestion liveSearchSuggestion2;
                String str5;
                LiveFeedSearchSuggestionAdapter.OnSuggestionListener suggestionListener;
                list5 = LiveFeedSearchSuggestionAdapter.this.suggestionList;
                if (list5 != null && (liveSearchSuggestion2 = (LiveSearchSuggestion) list5.get(intRef.element)) != null && (str5 = liveSearchSuggestion2.question) != null && (suggestionListener = LiveFeedSearchSuggestionAdapter.this.getSuggestionListener()) != null) {
                    suggestionListener.onSuggestionClick(str5, intRef.element);
                }
            }
        });
        searchSuggestionViewHolder.getSuggestionArrow().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter$onBindViewHolder$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                List list5;
                LiveSearchSuggestion liveSearchSuggestion2;
                String str5;
                LiveFeedSearchSuggestionAdapter.OnSuggestionListener suggestionListener;
                list5 = LiveFeedSearchSuggestionAdapter.this.suggestionList;
                if (list5 != null && (liveSearchSuggestion2 = (LiveSearchSuggestion) list5.get(intRef.element)) != null && (str5 = liveSearchSuggestion2.question) != null && (suggestionListener = LiveFeedSearchSuggestionAdapter.this.getSuggestionListener()) != null) {
                    suggestionListener.onSuggestionSelect(str5, intRef.element);
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            View view2 = View.inflate(this.mContext, R.layout.obfuscated_res_0x7f0d0605, null);
            Context context = this.mContext;
            Intrinsics.checkExpressionValueIsNotNull(view2, "view");
            return new LiveSearchResultViewHolder(context, view2, this.scene);
        }
        View view3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0601, viewGroup, false);
        Context context2 = this.mContext;
        Intrinsics.checkExpressionValueIsNotNull(view3, "view");
        return new SearchSuggestionViewHolder(context2, view3, this.scene);
    }

    public final void resultDataProcess(final int i, LiveSearchResultViewHolder liveSearchResultViewHolder) {
        LiveSearchResultInfo liveSearchResultInfo;
        String str;
        String str2;
        LiveSearchResultInfo liveSearchResultInfo2;
        String str3;
        String str4;
        boolean z;
        String str5;
        LiveSearchResultInfo liveSearchResultInfo3;
        LiveSearchResultInfo liveSearchResultInfo4;
        LiveSearchResultInfo liveSearchResultInfo5;
        LiveSearchResultInfo liveSearchResultInfo6;
        String str6;
        String str7;
        LiveSearchResultInfo liveSearchResultInfo7;
        String str8;
        List<? extends LiveSearchResultInfo> list = this.resultList;
        Boolean bool = null;
        if (list != null) {
            liveSearchResultInfo = list.get(i);
        } else {
            liveSearchResultInfo = null;
        }
        if (liveSearchResultInfo != null) {
            str = liveSearchResultInfo.description;
        } else {
            str = null;
        }
        if (str != null) {
            liveSearchResultViewHolder.h().setVisibility(0);
            liveSearchResultViewHolder.i().setVisibility(8);
            TextView h = liveSearchResultViewHolder.h();
            List<? extends LiveSearchResultInfo> list2 = this.resultList;
            if (list2 != null && (liveSearchResultInfo7 = list2.get(i)) != null && (str8 = liveSearchResultInfo7.displayName) != null) {
                str7 = wordNumCheck(str8, 8);
            } else {
                str7 = null;
            }
            h.setText(str7);
        } else {
            liveSearchResultViewHolder.h().setVisibility(8);
            liveSearchResultViewHolder.i().setVisibility(0);
            TextView i2 = liveSearchResultViewHolder.i();
            List<? extends LiveSearchResultInfo> list3 = this.resultList;
            if (list3 != null && (liveSearchResultInfo2 = list3.get(i)) != null && (str3 = liveSearchResultInfo2.displayName) != null) {
                str2 = wordNumCheck(str3, 8);
            } else {
                str2 = null;
            }
            i2.setText(str2);
        }
        TextView d = liveSearchResultViewHolder.d();
        List<? extends LiveSearchResultInfo> list4 = this.resultList;
        if (list4 != null && (liveSearchResultInfo6 = list4.get(i)) != null && (str6 = liveSearchResultInfo6.description) != null) {
            str4 = wordNumCheck(str6, 14);
        } else {
            str4 = null;
        }
        d.setText(str4);
        CharSequence text = liveSearchResultViewHolder.d().getText();
        if (text != null && text.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            liveSearchResultViewHolder.d().setVisibility(8);
            liveSearchResultViewHolder.h().setGravity(16);
        }
        SimpleDraweeView b = liveSearchResultViewHolder.b();
        List<? extends LiveSearchResultInfo> list5 = this.resultList;
        if (list5 != null && (liveSearchResultInfo5 = list5.get(i)) != null) {
            str5 = liveSearchResultInfo5.avatar;
        } else {
            str5 = null;
        }
        b.setImageURI(str5);
        List<? extends LiveSearchResultInfo> list6 = this.resultList;
        if (list6 != null && (liveSearchResultInfo4 = list6.get(i)) != null && liveSearchResultInfo4.hasFollowed) {
            if (Intrinsics.areEqual(this.scene, "recommend")) {
                liveSearchResultViewHolder.e().setVisibility(8);
            } else {
                liveSearchResultViewHolder.e().setVisibility(0);
                liveSearchResultViewHolder.e().setText("已关注");
                liveSearchResultViewHolder.e().setTypeface(Typeface.DEFAULT);
                liveSearchResultViewHolder.e().setTextColor(w80.f().a(liveSearchResultViewHolder.c(), this.scene, "color_8585852"));
                w80 f = w80.f();
                Intrinsics.checkExpressionValueIsNotNull(f, "UIModeUtils.getInstance()");
                String r = f.r();
                if (Intrinsics.areEqual(r, "day")) {
                    liveSearchResultViewHolder.e().setBackgroundResource(R.drawable.obfuscated_res_0x7f080f6a);
                } else if (Intrinsics.areEqual(r, "night")) {
                    liveSearchResultViewHolder.e().setBackgroundResource(R.drawable.obfuscated_res_0x7f080f6b);
                }
            }
        } else {
            liveSearchResultViewHolder.e().setVisibility(0);
            liveSearchResultViewHolder.e().setText("关注");
            liveSearchResultViewHolder.e().setTypeface(Typeface.DEFAULT_BOLD);
            liveSearchResultViewHolder.e().setTextColor(w80.f().a(liveSearchResultViewHolder.c(), this.scene, "color_white3"));
            w80 f2 = w80.f();
            Intrinsics.checkExpressionValueIsNotNull(f2, "UIModeUtils.getInstance()");
            String r2 = f2.r();
            if (Intrinsics.areEqual(r2, "day")) {
                liveSearchResultViewHolder.e().setBackgroundResource(R.drawable.obfuscated_res_0x7f080f68);
            } else if (Intrinsics.areEqual(r2, "night")) {
                liveSearchResultViewHolder.e().setBackgroundResource(R.drawable.obfuscated_res_0x7f080f69);
            }
        }
        liveSearchResultViewHolder.g().setVisibility(8);
        liveSearchResultViewHolder.f().setVisibility(8);
        List<? extends LiveSearchResultInfo> list7 = this.resultList;
        if (list7 != null && (liveSearchResultInfo3 = list7.get(i)) != null) {
            bool = Boolean.valueOf(liveSearchResultInfo3.hasLiving);
        }
        if (bool == null) {
            Intrinsics.throwNpe();
        }
        if (bool.booleanValue()) {
            liveSearchResultViewHolder.g().setVisibility(0);
            liveSearchResultViewHolder.f().setVisibility(0);
            w80 f3 = w80.f();
            Intrinsics.checkExpressionValueIsNotNull(f3, "UIModeUtils.getInstance()");
            String r3 = f3.r();
            if (Intrinsics.areEqual(r3, "day")) {
                liveSearchResultViewHolder.g().setAnimation("lottie/liveshow_rank_avatar_live_tag_day.json");
            } else if (Intrinsics.areEqual(r3, "night")) {
                liveSearchResultViewHolder.g().setAnimation("lottie/liveshow_rank_avatar_live_tag_night.json");
            }
            liveSearchResultViewHolder.g().playAnimation();
        } else {
            liveSearchResultViewHolder.g().setVisibility(8);
            liveSearchResultViewHolder.f().setVisibility(8);
            liveSearchResultViewHolder.l().setVisibility(8);
        }
        liveSearchResultViewHolder.l().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter$resultDataProcess$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LiveSearchResultInfo liveSearchResultInfo8;
                LiveSearchResultInfo liveSearchResultInfo9;
                String str9;
                LiveFeedSearchSuggestionAdapter.OnSuggestionListener suggestionListener;
                LiveSearchResultInfo liveSearchResultInfo10;
                LiveFeedSearchSuggestionAdapter.OnSuggestionListener suggestionListener2;
                LiveSearchResultInfo liveSearchResultInfo11;
                String str10;
                List<LiveSearchResultInfo> resultList = LiveFeedSearchSuggestionAdapter.this.getResultList();
                if (resultList != null) {
                    liveSearchResultInfo8 = resultList.get(i);
                } else {
                    liveSearchResultInfo8 = null;
                }
                if (liveSearchResultInfo8 == null) {
                    Intrinsics.throwNpe();
                }
                String str11 = "";
                if (liveSearchResultInfo8.hasLiving) {
                    List<LiveSearchResultInfo> resultList2 = LiveFeedSearchSuggestionAdapter.this.getResultList();
                    if (resultList2 != null && (liveSearchResultInfo11 = resultList2.get(i)) != null && (str10 = liveSearchResultInfo11.cmd) != null) {
                        str11 = str10;
                    }
                    LiveFeedPageSdk.liveLog("FeedItemClick: position: " + i + "  scheme: " + str11);
                    List<LiveSearchResultInfo> resultList3 = LiveFeedSearchSuggestionAdapter.this.getResultList();
                    if (resultList3 != null && (liveSearchResultInfo10 = resultList3.get(i)) != null && (suggestionListener2 = LiveFeedSearchSuggestionAdapter.this.getSuggestionListener()) != null) {
                        suggestionListener2.onResultClick(liveSearchResultInfo10);
                    }
                } else {
                    List<LiveSearchResultInfo> resultList4 = LiveFeedSearchSuggestionAdapter.this.getResultList();
                    if (resultList4 != null && (liveSearchResultInfo9 = resultList4.get(i)) != null && (str9 = liveSearchResultInfo9.cmd) != null) {
                        str11 = str9;
                    }
                    LiveFeedPageSdk.liveLog("FeedItemClick: position: " + i + "  scheme: " + str11);
                    LiveFeedSearchSuggestionAdapter.OnSuggestionListener suggestionListener3 = LiveFeedSearchSuggestionAdapter.this.getSuggestionListener();
                    if (suggestionListener3 != null) {
                        suggestionListener3.jumpAuthorView(str11);
                    }
                }
                List<LiveSearchResultInfo> resultList5 = LiveFeedSearchSuggestionAdapter.this.getResultList();
                if (resultList5 != null && (suggestionListener = LiveFeedSearchSuggestionAdapter.this.getSuggestionListener()) != null) {
                    suggestionListener.onUbcResult(resultList5, i, "clk");
                }
            }
        });
        liveSearchResultViewHolder.e().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.feed.search.adapter.LiveFeedSearchSuggestionAdapter$resultDataProcess$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Boolean bool2;
                LiveFeedSearchSuggestionAdapter.OnSuggestionListener suggestionListener;
                LiveSearchResultInfo liveSearchResultInfo8;
                LiveFeedSearchSuggestionAdapter.OnSuggestionListener suggestionListener2;
                LiveFeedSearchSuggestionAdapter.OnSuggestionListener suggestionListener3;
                List<LiveSearchResultInfo> resultList = LiveFeedSearchSuggestionAdapter.this.getResultList();
                if (resultList == null) {
                    Intrinsics.throwNpe();
                }
                LiveSearchResultInfo liveSearchResultInfo9 = resultList.get(i);
                if (liveSearchResultInfo9 != null) {
                    bool2 = Boolean.valueOf(liveSearchResultInfo9.hasFollowed);
                } else {
                    bool2 = null;
                }
                if (bool2 == null) {
                    Intrinsics.throwNpe();
                }
                if (!bool2.booleanValue()) {
                    List<LiveSearchResultInfo> resultList2 = LiveFeedSearchSuggestionAdapter.this.getResultList();
                    if (resultList2 == null) {
                        Intrinsics.throwNpe();
                    }
                    LiveSearchResultInfo liveSearchResultInfo10 = resultList2.get(i);
                    if (liveSearchResultInfo10 != null && (suggestionListener3 = LiveFeedSearchSuggestionAdapter.this.getSuggestionListener()) != null) {
                        suggestionListener3.onFollowClick(liveSearchResultInfo10, i);
                        return;
                    }
                    return;
                }
                List<LiveSearchResultInfo> resultList3 = LiveFeedSearchSuggestionAdapter.this.getResultList();
                if (resultList3 != null && (liveSearchResultInfo8 = resultList3.get(i)) != null && (suggestionListener2 = LiveFeedSearchSuggestionAdapter.this.getSuggestionListener()) != null) {
                    suggestionListener2.onResultClick(liveSearchResultInfo8);
                }
                List<LiveSearchResultInfo> resultList4 = LiveFeedSearchSuggestionAdapter.this.getResultList();
                if (resultList4 != null && (suggestionListener = LiveFeedSearchSuggestionAdapter.this.getSuggestionListener()) != null) {
                    suggestionListener.onUbcResult(resultList4, i, "clk");
                }
            }
        });
        StaggeredGridLayoutManager.LayoutParams layoutParams = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
        layoutParams.setFullSpan(true);
        View view2 = liveSearchResultViewHolder.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view2, "holder.itemView");
        view2.setLayoutParams(layoutParams);
    }

    public final void setFollowStatus(int i) {
        boolean z;
        LiveSearchResultInfo liveSearchResultInfo;
        List<? extends LiveSearchResultInfo> list = this.resultList;
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (!z && i >= 0) {
            List<? extends LiveSearchResultInfo> list2 = this.resultList;
            if (list2 == null) {
                Intrinsics.throwNpe();
            }
            if (i < list2.size()) {
                List<? extends LiveSearchResultInfo> list3 = this.resultList;
                if (list3 != null && (liveSearchResultInfo = list3.get(i)) != null) {
                    liveSearchResultInfo.hasFollowed = true;
                }
                notifyItemChanged(i);
            }
        }
    }

    public final void setSuggestions(List<? extends LiveSearchResultInfo> list, List<? extends LiveSearchSuggestion> list2, String str) {
        boolean z;
        boolean z2;
        Integer num;
        boolean z3;
        this.resultList = list;
        this.suggestionList = list2;
        this.contentText = str;
        ArrayList<Integer> arrayList = this.typeList;
        if (arrayList != null) {
            arrayList.clear();
        }
        boolean z4 = true;
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            if (list2 != null && !list2.isEmpty()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (!z3) {
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
        if (list != null && !list.isEmpty()) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            if (list != null) {
                num = Integer.valueOf(list.size());
            } else {
                num = null;
            }
            int intValue = num.intValue();
            for (int i2 = 0; i2 < intValue; i2++) {
                ArrayList<Integer> arrayList4 = this.typeList;
                if (arrayList4 != null) {
                    arrayList4.add(1);
                }
            }
        } else {
            if (list2 != null && !list2.isEmpty()) {
                z4 = false;
            }
            if (!z4) {
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
