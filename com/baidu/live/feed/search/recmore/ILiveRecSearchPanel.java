package com.baidu.live.feed.search.recmore;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.facebook.common.util.UriUtil;
import java.util.List;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u00015J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u0011\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H&¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0010H&¢\u0006\u0004\b\u0014\u0010\u0012J\u0019\u0010\u0017\u001a\u00020\u00102\b\b\u0001\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001e\u001a\u00020\u00102\b\b\u0001\u0010\u001d\u001a\u00020\u0015H&¢\u0006\u0004\b\u001e\u0010\u0018J\u0017\u0010!\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b!\u0010\"J+\u0010&\u001a\u00020\u00102\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010$H&¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\u00102\u0006\u0010 \u001a\u00020(H&¢\u0006\u0004\b)\u0010*J\u0019\u0010,\u001a\u00020\u00102\b\u0010+\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b,\u0010-J\u0019\u0010.\u001a\u00020\u00102\b\b\u0001\u0010\u001d\u001a\u00020\u0015H&¢\u0006\u0004\b.\u0010\u0018J\u0019\u00100\u001a\u00020\u00102\b\b\u0001\u0010/\u001a\u00020\u0015H&¢\u0006\u0004\b0\u0010\u0018J\u0017\u00103\u001a\u00020\u00102\u0006\u00102\u001a\u000201H&¢\u0006\u0004\b3\u00104¨\u00066"}, d2 = {"Lcom/baidu/live/feed/search/recmore/ILiveRecSearchPanel;", "Lkotlin/Any;", "", "getCurrentQueryHint", "()Ljava/lang/String;", "Landroid/widget/EditText;", "getEditText", "()Landroid/widget/EditText;", "getText", "Landroid/view/View;", "getView", "()Landroid/view/View;", "Landroid/content/Context;", "context", "onCreate", "(Landroid/content/Context;)Landroid/view/View;", "", MissionEvent.MESSAGE_DESTROY, "()V", "requestInput", "resetView", "", UriUtil.LOCAL_RESOURCE_SCHEME, "setBackgroundResource", "(I)V", "", "editable", "setEditable", "(Z)V", "color", "setHintTextColor", "Landroid/view/View$OnClickListener;", "listener", "setOnEditClickListener", "(Landroid/view/View$OnClickListener;)V", "curShowHint", "", "hintList", "setQueryHintList", "(Ljava/lang/String;Ljava/util/List;)V", "Lcom/baidu/live/feed/search/recmore/ILiveRecSearchPanel$OnSearchPanelListener;", "setQueryListener", "(Lcom/baidu/live/feed/search/recmore/ILiveRecSearchPanel$OnSearchPanelListener;)V", "editText", "setText", "(Ljava/lang/String;)V", "setTextColor", "textCursorDrawable", "setTextCursorDrawable", "", "pxValue", "setTextSize", "(F)V", "OnSearchPanelListener", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface ILiveRecSearchPanel {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static /* synthetic */ void setQueryHintList$default(ILiveRecSearchPanel iLiveRecSearchPanel, String str, List list, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                iLiveRecSearchPanel.setQueryHintList(str, list);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setQueryHintList");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/baidu/live/feed/search/recmore/ILiveRecSearchPanel$OnSearchPanelListener;", "Lkotlin/Any;", "", "onCancelClick", "()V", "", "newText", "onQueryTextChange", "(Ljava/lang/String;)V", "query", "onQueryTextSubmit", "lib-live-feed-search_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface OnSearchPanelListener {
        void onCancelClick();

        void onQueryTextChange(String str);

        void onQueryTextSubmit(String str);
    }

    String getCurrentQueryHint();

    EditText getEditText();

    String getText();

    View getView();

    View onCreate(Context context);

    void onDestroy();

    void requestInput();

    void resetView();

    void setBackgroundResource(@DrawableRes int i);

    void setEditable(boolean z);

    void setHintTextColor(@ColorInt int i);

    void setOnEditClickListener(View.OnClickListener onClickListener);

    void setQueryHintList(String str, List<String> list);

    void setQueryListener(OnSearchPanelListener onSearchPanelListener);

    void setText(String str);

    void setTextColor(@ColorInt int i);

    void setTextCursorDrawable(@DrawableRes int i);

    void setTextSize(float f);
}
