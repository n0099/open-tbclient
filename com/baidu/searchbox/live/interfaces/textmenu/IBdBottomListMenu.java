package com.baidu.searchbox.live.interfaces.textmenu;

import android.view.View;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0005H&¢\u0006\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/textmenu/IBdBottomListMenu;", "Lkotlin/Any;", "", "dismissMenu", "()V", "", "menuId", "dispatchMenuClick", "(I)V", "", "isShowing", "()Z", "Landroid/view/View;", "anchor", "showMenu", "(Landroid/view/View;)V", "requestTag", "updateMenuContent", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface IBdBottomListMenu {
    void dismissMenu();

    void dispatchMenuClick(int i);

    boolean isShowing();

    void showMenu(View view2);

    void updateMenuContent(int i);
}
