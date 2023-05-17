package com.baidu.searchbox.live.interfaces.service.bd;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.live.interfaces.bottombar.OnBottomBarElementClickListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Map;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ!\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0011H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u0004H&¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/bd/IBottomBarInterface;", "Lkotlin/Any;", "Landroid/content/Context;", "context", "", "isResponseFontSize", "isDarkMode", "Landroid/view/View;", "createFloatingBackBottomBar", "(Landroid/content/Context;ZZ)Landroid/view/View;", "createInteractSimpleBottomBar", "(Landroid/content/Context;Z)Landroid/view/View;", "", "bottomElementID", "getElementSelectState", "(Ljava/lang/String;)Z", "elementId", "", "params", "", "onElementsShowEventStatistic", "(Ljava/lang/String;Ljava/util/Map;)V", "Lcom/baidu/searchbox/live/interfaces/bottombar/OnBottomBarElementClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setBottomBarElementClickListener", "(Lcom/baidu/searchbox/live/interfaces/bottombar/OnBottomBarElementClickListener;)V", "isSelected", "showAnim", "setElementSelectState", "(Ljava/lang/String;ZZ)V", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface IBottomBarInterface {
    View createFloatingBackBottomBar(Context context, boolean z, boolean z2);

    View createInteractSimpleBottomBar(Context context, boolean z);

    boolean getElementSelectState(String str);

    void onElementsShowEventStatistic(String str, Map<String, String> map);

    void setBottomBarElementClickListener(OnBottomBarElementClickListener onBottomBarElementClickListener);

    void setElementSelectState(String str, boolean z, boolean z2);

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ View createFloatingBackBottomBar$default(IBottomBarInterface iBottomBarInterface, Context context, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    z2 = false;
                }
                return iBottomBarInterface.createFloatingBackBottomBar(context, z, z2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createFloatingBackBottomBar");
        }

        public static /* synthetic */ void setElementSelectState$default(IBottomBarInterface iBottomBarInterface, String str, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    z2 = false;
                }
                iBottomBarInterface.setElementSelectState(str, z, z2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setElementSelectState");
        }
    }
}
