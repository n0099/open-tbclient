package com.baidu.searchbox.live.interfaces.textmenu;

import android.view.View;
import com.baidu.searchbox.crius.constants.NativeConstants;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001:\u0001#J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\tH&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0002H&¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0002H&¢\u0006\u0004\b\u0015\u0010\u0004J\u001f\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH&¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0002H&¢\u0006\u0004\b\u001e\u0010\u0004J\u001f\u0010!\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH&¢\u0006\u0004\b!\u0010\u0019J\u000f\u0010\"\u001a\u00020\u0002H&¢\u0006\u0004\b\"\u0010\u0004¨\u0006$"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/textmenu/IBdTextSelectHelper;", "Lkotlin/Any;", "", "cancelSelect", "()V", "changeCursorDirection", "", "getTextSelected", "()Ljava/lang/CharSequence;", "", "getTextSelectedEnd", "()I", "getTextSelectedStart", "", "showAnimator", "hideSelectView", "(Z)V", "duration", "postShowSelectView", "(I)V", "removeCustomMenu", "resetSelectionInfo", "start", "end", "selectText", "(II)V", "Lcom/baidu/searchbox/live/interfaces/textmenu/IBdTextSelectHelper$SelectableTextLongClickListener;", "listener", "setSelectableTextLongClickListener", "(Lcom/baidu/searchbox/live/interfaces/textmenu/IBdTextSelectHelper$SelectableTextLongClickListener;)V", "showBackgroundWindow", "touchX", "touchY", "showSelectView", "startSelect", "SelectableTextLongClickListener", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface IBdTextSelectHelper {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/textmenu/IBdTextSelectHelper$SelectableTextLongClickListener;", "Lkotlin/Any;", "Landroid/view/View;", NativeConstants.TYPE_VIEW, "", "onLongClick", "(Landroid/view/View;)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public interface SelectableTextLongClickListener {
        void onLongClick(View view2);
    }

    void cancelSelect();

    void changeCursorDirection();

    CharSequence getTextSelected();

    int getTextSelectedEnd();

    int getTextSelectedStart();

    void hideSelectView(boolean z);

    void postShowSelectView(int i);

    void removeCustomMenu();

    void resetSelectionInfo();

    void selectText(int i, int i2);

    void setSelectableTextLongClickListener(SelectableTextLongClickListener selectableTextLongClickListener);

    void showBackgroundWindow();

    void showSelectView(int i, int i2);

    void startSelect();
}
