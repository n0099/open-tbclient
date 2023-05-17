package com.baidu.searchbox.live.interfaces.service.bd;

import android.content.Context;
import android.view.View;
import androidx.transition.Transition;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/bd/IMenuInterface;", "Lkotlin/Any;", "", "animation", "", "hideMenu", "(Z)V", "isShowing", "()Z", "Landroid/content/Context;", "context", "Landroid/view/View;", "attachView", "", "ukey", "Lcom/baidu/searchbox/live/interfaces/service/bd/IMenuInterface$OnCommonMenuItemClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "showMenu", "(Landroid/content/Context;Landroid/view/View;Ljava/lang/String;Lcom/baidu/searchbox/live/interfaces/service/bd/IMenuInterface$OnCommonMenuItemClickListener;)V", "OnCommonMenuItemClickListener", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface IMenuInterface {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/bd/IMenuInterface$OnCommonMenuItemClickListener;", "Lkotlin/Any;", "Landroid/view/View;", "v", "", Transition.MATCH_ITEM_ID_STR, "", "onClick", "(Landroid/view/View;I)Z", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public interface OnCommonMenuItemClickListener {
        boolean onClick(View view2, int i);
    }

    void hideMenu(boolean z);

    boolean isShowing();

    void showMenu(Context context, View view2, String str, OnCommonMenuItemClickListener onCommonMenuItemClickListener);
}
